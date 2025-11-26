package org.example.websitesalephone.auth;

import com.prj.tpp.data.entity.TppMember;
import com.prj.tpp.data.entity.office.TppOfficeType;
import com.prj.tpp.data.entity.role.TppPermission;
import com.prj.tpp.data.repository.MemberRepository;
import com.prj.tpp.data.repository.role.GroupPermissionRepository;
import com.prj.tpp.data.repository.role.OfficeRepository;
import com.prj.tpp.data.repository.role.PermissionRepository;
import com.prj.tpp.data.repository.role.UserRoleRepository;
import com.prj.tpp.web.common.Constants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PermissionAuthenticationFilter extends OncePerRequestFilter {


    private static final String AUTH_HEADER = "Authorization";

    private final UserRoleRepository userRoleRepository;
    private final GroupPermissionRepository groupPermissionRepository;
    private final PermissionRepository permissionRepository;
    private final MemberRepository memberRepository;
    private final OfficeRepository officeRepository;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTH_HEADER);
        if (authHeader == null) {
            filterChain.doFilter(request, response);
        } else {
            try {
                // Check white list
                List<String> whiteList = Constants.WHITE_LIST_API;
                // check if request uri contains string in white list
                if (whiteList.stream().anyMatch(request.getRequestURI()::contains)) {
                    filterChain.doFilter(request, response);
                    return;
                }

                boolean hasPermission = this.canAccessApi(request);
                if (hasPermission) {
                    filterChain.doFilter(request, response);
                } else {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    /**
     * Method check user permission to access API
     *
     * @param request HttpServletRequest
     * @return True if user has permission to access API, otherwise False
     */
    private boolean canAccessApi(HttpServletRequest request) {
        var user = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        TppMember member = memberRepository.findByUserIdAndIsDeleted(user.getUserId(), false).orElse(null);

        if (member == null) {
            return false;
        }

        if (member.getOffice().getOfficeType().equals(TppOfficeType.SYSTEM_ADMIN)) {
            return true;
        }

        // Get role permissions
        List<String> permissionIds = groupPermissionRepository.findByUserRoleId(member.getRole().getId())
                .stream().map(e -> e.getId().getPermissionId()).toList();
        // Find all permissions
        List<TppPermission> userPermissions = permissionRepository.findByIdInAndIsDeleted(permissionIds, false);
        // Extract request URI path
        List<String> requestParts = Arrays.stream(request.getRequestURI().replace(contextPath, "").split("/"))
                .filter(e -> !e.isBlank()).toList();
        if (requestParts.size() >= 3) {
            String mainRequestUrl = requestParts.get(0) + "/" + requestParts.get(1);
            String methodPath = requestParts.get(2);
            List<TppPermission> allowedPermissions = permissionRepository.findByScreenCodeAndIdInAndIsDeleted(
                    mainRequestUrl,
                    userPermissions.stream().map(TppPermission::getId).toList(),
                    false
            );
            // Check screen permissions
            if (!allowedPermissions.isEmpty()) {
                for (TppPermission permission : allowedPermissions) {
                    if (methodPath.contains("create") && permission.getCanCreate()) {
                        return true;
                    } else if (methodPath.contains("delete") && permission.getCanDelete()) {
                        return true;
                    } else if (methodPath.contains("get") && permission.getCanRead()) {
                        return true;
                    } else if (methodPath.contains("update") && permission.getCanUpdate()) {
                        return true;
                    } else if (methodPath.contains("import") && permission.getCanImport()) {
                        return true;
                    } else if (methodPath.contains("export") && permission.getCanExport()) {
                        return true;
                    } else if (methodPath.contains("search")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
