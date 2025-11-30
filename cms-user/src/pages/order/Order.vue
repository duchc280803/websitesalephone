<script setup lang="ts">
import {ref, onMounted, computed} from "vue";
import {orderService} from "@/service/OrderService";
import {Search} from "@/models/Search.ts";

const orders = ref<any>();
const searchText = ref("");
const page = ref(1);
const size = ref(10);
const totalItems = ref(0);

const callSearch = async () => {
  const search = new Search(page.value, size.value, searchText.value);
  const res = await orderService.search(search);
  orders.value = res.data.data;
  totalItems.value = res.data.total || 0;
};

const onSearch = () => {
  page.value = 1;
  callSearch();
};

const onPageChange = (newPage: number) => {
  page.value = newPage;
  callSearch();
};

onMounted(() => {
  callSearch();
});
</script>

<template>
  <section class="content-card" id="orders">
    <div class="card-header">
      <h2 class="card-title">📦 Quản Lý Đơn Hàng</h2>
      <div class="card-actions">
        <button class="btn btn-secondary" @click="callSearch">🔍 Tìm kiếm</button>
        <button class="btn btn-primary">+ Thêm Đơn</button>
      </div>
    </div>
    <div class="tabs">
      <button class="tab active">Tất Cả (245)</button>
      <button class="tab">Chờ Xử Lý (45)</button>
      <button class="tab">Chờ lấy hàng (45)</button>
      <button class="tab">Chờ giao hàng (120)</button>
      <button class="tab">Đã giao (75)</button>
      <button class="tab">Đã Hủy (5)</button>
    </div>
    <div class="table-wrapper">
      <table>
        <thead>
        <tr>
          <th>Mã ĐH</th>
          <th>Khách Hàng</th>
          <th>SĐT KH</th>
          <th>Mã nhân viên</th>
          <th>Ngày tạo</th>
          <th>Ngày thanh toán</th>
          <th>Trạng Thái</th>
          <th>Số lượng</th>
          <th>Tổng tiền sản phẩm</th>
          <th>Phí vận chuyển</th>
          <th>Tổng tiền hóa đơn</th>
          <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="o in orders?.content" :key="o.order_id">
          <td>#{{ o.orderCode }}</td>
          <td>{{ o.userName }}</td>
          <td>{{ o.phone }}</td>
          <td>{{ o.codeUser }}</td>
          <td>{{ o.createdAt }}</td>
          <td>{{ o.dateTimeCheckout }}</td>
          <td>{{ o.status }}</td>
          <td>{{ o.quantity }}</td>
          <td>{{ o.totalPrice }}</td>
          <td>{{ o.shippingFee }}</td>
          <td>{{ o.totalOrderAmount }}</td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="pagination">
      <button class="page-btn" :disabled="page === 1" @click="onPageChange(1)">⟨⟨ Đầu</button>
      <button class="page-btn" :disabled="page === 1" @click="onPageChange(page - 1)">⟨ Trước</button>
      <span class="page-info">Trang {{ page }} / {{ Math.ceil(totalItems / size) }}</span>
      <button class="page-btn" :disabled="page === Math.ceil(totalItems / size)" @click="onPageChange(page + 1)">Sau ⟩</button>
      <button class="page-btn" :disabled="page === Math.ceil(totalItems / size)" @click="onPageChange(Math.ceil(totalItems / size))">Cuối ⟩⟩</button>
    </div>
  </section><!-- Products Table -->
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
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: #1a1a2e;
  line-height: 1.6;
}

.admin-wrapper {
  display: flex;
  min-height: 100%;
}

.nav-menu li {
  margin-bottom: 5px;
}

.nav-menu a {
  color: rgba(255, 255, 255, 0.8);
  text-decoration: none;
  padding: 15px 30px;
  display: flex;
  align-items: center;
  gap: 15px;
  font-weight: 600;
  font-size: 1.05em;
  transition: all 0.3s ease;
  border-left: 4px solid transparent;
}

.nav-menu a:hover,
.nav-menu a.active {
  background: rgba(255, 255, 255, 0.1);
  color: white;
  border-left-color: #fee140;
}

.nav-icon {
  font-size: 1.4em;
  width: 30px;
  text-align: center;
}

/* Main Content */
.main-content {
  flex: 1;
  padding: 40px;
  overflow-y: auto;
}

.page-title {
  font-size: 2.5em;
  font-weight: 800;
  color: #1a1a2e;
  margin-bottom: 10px;
}

.breadcrumb {
  color: #666;
  font-size: 1.05em;
}

.breadcrumb a {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
}

/* Stats Cards */
.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
  gap: 25px;
  margin-bottom: 40px;
}

.stat-card {
  background: white;
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
  position: relative;
  overflow: hidden;
  transition: all 0.3s ease;
}

.stat-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 15px 35px rgba(0, 0, 0, 0.12);
}

.stat-card::before {
  content: '';
  position: absolute;
  top: 0;
  right: 0;
  width: 100px;
  height: 100px;
  background: radial-gradient(circle, rgba(102, 126, 234, 0.1) 0%, transparent 70%);
  border-radius: 50%;
  transform: translate(30%, -30%);
}

.stat-icon {
  font-size: 3em;
  margin-bottom: 15px;
  display: inline-block;
}

.stat-value {
  font-size: 2.2em;
  font-weight: 800;
  color: #1a1a2e;
  margin-bottom: 5px;
}

.stat-label {
  color: #666;
  font-size: 1.05em;
  font-weight: 600;
}

.stat-trend {
  margin-top: 10px;
  font-size: 0.9em;
  font-weight: 600;
}

.trend-up {
  color: #43e97b;
}

.trend-down {
  color: #ff6b6b;
}

/* Content Card */
.content-card {
  background: white;
  border-radius: 20px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
  margin-bottom: 30px;
  overflow: hidden;
}

.card-header {
  padding: 25px 30px;
  border-bottom: 2px solid #f0f0f0;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-title {
  font-size: 1.6em;
  font-weight: 700;
  color: #1a1a2e;
  display: flex;
  align-items: center;
  gap: 10px;
}

.card-actions {
  display: flex;
  gap: 10px;
}

.btn {
  padding: 10px 25px;
  border-radius: 25px;
  border: none;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  font-size: 0.95em;
  text-decoration: none;
  display: inline-block;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 20px rgba(102, 126, 234, 0.4);
}

.btn-secondary {
  background: #f0f0f0;
  color: #1a1a2e;
}

.btn-secondary:hover {
  background: #e0e0e0;
}

/* Table */
.table-wrapper {
  overflow-x: auto;
  width: 100%;
}

table {
  width: 100%;
  table-layout: auto; /* cho cột tự co giãn */
}

thead {
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
}

th, td {
  white-space: nowrap; /* không xuống dòng */
  padding: 15px 20px;
  text-align: center;
}

th {
  padding: 20px 25px;
  text-align: left;
  font-weight: 700;
  color: #1a1a2e;
  font-size: 1em;
  border-bottom: 2px solid #e0e0e0;
}

td {
  padding: 20px 25px;
  border-bottom: 1px solid #f0f0f0;
  font-size: 0.98em;
}

tbody tr {
  transition: all 0.3s ease;
}

tbody tr:hover {
  background: #f9f9f9;
  transform: scale(1.01);
}

.table-wrapper::-webkit-scrollbar {
  height: 6px;
}

.table-wrapper::-webkit-scrollbar-thumb {
  background: #667eea;
  border-radius: 10px;
}

/* Status Badges */
.status-badge {
  padding: 6px 16px;
  border-radius: 20px;
  font-size: 0.85em;
  font-weight: 700;
  display: inline-block;
}

.status-pending {
  background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
  color: #d35400;
}

.status-processing {
  background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
  color: #0c5c7a;
}

.status-completed {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: #0d6e3e;
}

.status-cancelled {
  background: linear-gradient(135deg, #ff6b6b 0%, #ee5a6f 100%);
  color: #7a0c0c;
}

.status-active {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: #0d6e3e;
}

.status-inactive {
  background: linear-gradient(135deg, #c3cfe2 0%, #a8b8d8 100%);
  color: #4a5568;
}

/* Product Image */
.product-cell {
  display: flex;
  align-items: center;
  gap: 15px;
}

.product-image {
  width: 50px;
  height: 50px;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.8em;
  flex-shrink: 0;
}

.product-info {
  flex: 1;
}

.product-name {
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 3px;
}

.product-sku {
  font-size: 0.9em;
  color: #666;
}

/* User Avatar */
.user-cell {
  display: flex;
  align-items: center;
  gap: 15px;
}

.user-avatar {
  width: 45px;
  height: 45px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.5em;
  color: white;
  flex-shrink: 0;
}

.user-info {
  flex: 1;
}

.user-name {
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 3px;
}

.user-email {
  font-size: 0.9em;
  color: #666;
}

/* Action Buttons */
.action-buttons {
  display: flex;
  gap: 8px;
}

.action-btn {
  width: 35px;
  height: 35px;
  border-radius: 10px;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease;
  font-size: 1.1em;
  display: flex;
  align-items: center;
  justify-content: center;
}

.action-btn:hover {
  transform: scale(1.15);
}

.btn-view {
  background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
  color: white;
}

.btn-edit {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: white;
}

.btn-delete {
  background: linear-gradient(135deg, #ff6b6b 0%, #ee5a6f 100%);
  color: white;
}

/* Price */
.price {
  font-weight: 700;
  color: #667eea;
  font-size: 1.05em;
}

/* Tabs */
.tabs {
  display: flex;
  gap: 10px;
  padding: 25px 30px 0;
  border-bottom: 2px solid #f0f0f0;
}

.tab {
  padding: 12px 30px;
  background: transparent;
  border: none;
  font-weight: 600;
  color: #666;
  cursor: pointer;
  transition: all 0.3s ease;
  border-bottom: 3px solid transparent;
  margin-bottom: -2px;
  font-size: 1em;
}

.tab:hover,
.tab.active {
  color: #667eea;
  border-bottom-color: #667eea;
}

/* Responsive */
@media (max-width: 1200px) {
  .sidebar {
    width: 240px;
  }
}

@media (max-width: 968px) {
  .admin-wrapper {
    flex-direction: column;
  }

  .sidebar {
    width: 100%;
    position: relative;
    height: auto;
  }

  .main-content {
    padding: 20px;
  }

  .stats-grid {
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  }

  .page-title {
    font-size: 2em;
  }

  .table-wrapper {
    overflow-x: scroll;
  }

  table {
    min-width: 800px;
  }
}

@media (max-width: 480px) {
  .page-title {
    font-size: 1.6em;
  }

  .stats-grid {
    grid-template-columns: 1fr;
  }

  .card-header {
    flex-direction: column;
    gap: 15px;
    align-items: flex-start;
  }
}
/* Pagination */
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-top: 40px;
  flex-wrap: wrap;
}

.page-btn {
  min-width: 45px;
  height: 45px;
  padding: 0 15px;
  background: white;
  color: #666;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  font-weight: 700;
  font-size: 1em;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.page-btn:hover {
  border-color: #667eea;
  color: #667eea;
  transform: translateY(-2px);
}

.page-btn.active {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border-color: #667eea;
}

.page-btn:disabled {
  opacity: 0.3;
  cursor: not-allowed;
}

.page-btn:disabled:hover {
  transform: none;
  border-color: #e0e0e0;
  color: #666;
}

.page-info {
  padding: 12px 20px;
  background: white;
  border-radius: 12px;
  font-weight: 600;
  color: #666;
}

</style>