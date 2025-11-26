<script setup lang="ts">

</script>

<template>
  <main class="login-wrapper">
    <div class="login-container"><!-- Logo Section -->
      <div class="logo-section">
        <div class="admin-badge">
          🛡️ ADMIN PANEL
        </div>
        <div class="logo">
          🔐
        </div>
        <h1 class="brand-name">Phone Store Admin</h1>
        <p class="welcome-text">Đăng nhập hệ thống quản trị</p>
      </div><!-- Security Notice -->
      <div class="security-notice"><span>⚠️</span> <span>Chỉ dành cho quản trị viên. Không chia sẻ thông tin đăng nhập.</span>
      </div><!-- Error/Success Messages -->
      <div class="error-message" id="errorMessage"><span>⚠️</span> <span id="errorText"></span>
      </div>
      <div class="success-message" id="successMessage"><span>✓</span> <span id="successText"></span>
      </div><!-- Login Form -->
      <form class="login-form" id="loginForm">
        <div class="form-group"><label for="username" class="form-label">Tên đăng nhập Admin</label>
          <div class="input-wrapper"><span class="input-icon">👨‍💼</span> <input type="text" id="username" class="form-input" placeholder="Nhập tên đăng nhập" required autocomplete="username">
          </div>
        </div>
        <div class="form-group"><label for="password" class="form-label">Mật khẩu</label>
          <div class="input-wrapper"><span class="input-icon">🔒</span> <input type="password" id="password" class="form-input" placeholder="Nhập mật khẩu" required autocomplete="current-password"> <button type="button" class="password-toggle" id="togglePassword"> 👁️ </button>
          </div>
        </div>
        <div class="form-options"><a href="#" class="forgot-password">Quên mật khẩu?</a>
        </div><button type="submit" class="login-btn"> 🔓 Đăng nhập Admin <span>→</span> </button>
      </form><!-- Back to User Login -->
      <div class="back-to-user"><a href="#user-login"> ← Về trang đăng nhập khách hàng </a>
      </div><!-- Footer -->
      <div class="admin-footer">
        🔒 Kết nối bảo mật · Phone Store Admin v1.0
      </div>
    </div>
  </main>
</template>

<style scoped>
body {
  box-sizing: border-box;
}

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html, body {
  height: 100%;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, sans-serif;
  background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
  color: #1a1a2e;
  line-height: 1.6;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
}

.login-wrapper {
  width: 100%;
  max-width: 480px;
  margin-left: 700px;
}

.login-container {
  background: white;
  border-radius: 20px;
  padding: 45px 40px;
  box-shadow: 0 20px 60px rgba(0, 0, 0, 0.4);
  animation: slideUp 0.5s ease;
}

@keyframes slideUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.logo-section {
  text-align: center;
  margin-bottom: 35px;
}

.admin-badge {
  display: inline-block;
  padding: 8px 20px;
  background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
  color: white;
  border-radius: 25px;
  font-size: 0.85em;
  font-weight: 700;
  margin-bottom: 20px;
  letter-spacing: 1px;
}

.logo {
  font-size: 4em;
  margin-bottom: 15px;
}

.brand-name {
  font-size: 1.8em;
  font-weight: 800;
  color: #1e3c72;
  margin-bottom: 8px;
}

.welcome-text {
  color: #666;
  font-size: 0.95em;
  font-weight: 500;
}

.security-notice {
  background: #fff3cd;
  border-left: 4px solid #ffc107;
  padding: 12px 15px;
  margin: 25px 0;
  border-radius: 8px;
  font-size: 0.9em;
  color: #856404;
  display: flex;
  align-items: center;
  gap: 10px;
}

.login-form {
  margin-top: 30px;
}

.form-group {
  margin-bottom: 25px;
}

.form-label {
  display: block;
  font-weight: 600;
  color: #1a1a2e;
  margin-bottom: 10px;
  font-size: 0.95em;
}

.input-wrapper {
  position: relative;
}

.input-icon {
  position: absolute;
  left: 15px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1.2em;
  color: #999;
}

.form-input {
  width: 100%;
  padding: 14px 15px 14px 45px;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  font-size: 1em;
  transition: all 0.3s ease;
  font-family: inherit;
}

.form-input:focus {
  outline: none;
  border-color: #2a5298;
  box-shadow: 0 0 0 4px rgba(42, 82, 152, 0.1);
}

.form-input::placeholder {
  color: #bbb;
}

.password-toggle {
  position: absolute;
  right: 15px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  font-size: 1.2em;
  color: #999;
  transition: color 0.3s ease;
}

.password-toggle:hover {
  color: #2a5298;
}

.two-factor-info {
  background: #e3f2fd;
  border-left: 4px solid #2196f3;
  padding: 12px 15px;
  margin-top: 10px;
  border-radius: 8px;
  font-size: 0.85em;
  color: #1565c0;
  display: flex;
  align-items: center;
  gap: 8px;
}

.form-options {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 25px;
  font-size: 0.9em;
}

.forgot-password {
  color: #2a5298;
  text-decoration: none;
  font-weight: 600;
  transition: color 0.3s ease;
}

.forgot-password:hover {
  color: #1e3c72;
}

.login-btn {
  width: 100%;
  padding: 16px;
  background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
  color: white;
  border: none;
  border-radius: 12px;
  font-size: 1.05em;
  font-weight: 700;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
}

.login-btn:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 25px rgba(30, 60, 114, 0.4);
}

.login-btn:active {
  transform: translateY(0);
}

.error-message {
  background: #ffe0e0;
  color: #d32f2f;
  padding: 12px 15px;
  border-radius: 10px;
  font-size: 0.9em;
  margin-bottom: 20px;
  display: none;
  align-items: center;
  gap: 8px;
}

.error-message.show {
  display: flex;
}

.success-message {
  background: #e0ffe0;
  color: #2e7d32;
  padding: 12px 15px;
  border-radius: 10px;
  font-size: 0.9em;
  margin-bottom: 20px;
  display: none;
  align-items: center;
  gap: 8px;
}

.success-message.show {
  display: flex;
}

.back-to-user {
  text-align: center;
  margin-top: 25px;
  padding-top: 25px;
  border-top: 2px solid #f0f0f0;
}

.back-to-user a {
  color: #2a5298;
  text-decoration: none;
  font-weight: 600;
  font-size: 0.9em;
  display: inline-flex;
  align-items: center;
  gap: 6px;
  transition: color 0.3s ease;
}

.back-to-user a:hover {
  color: #1e3c72;
}

.admin-footer {
  text-align: center;
  margin-top: 25px;
  color: #999;
  font-size: 0.85em;
}

/* Responsive */
@media (max-width: 480px) {
  .login-container {
    padding: 35px 25px;
  }

  .brand-name {
    font-size: 1.5em;
  }
}
</style>