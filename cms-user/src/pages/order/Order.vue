<script setup lang="ts">
import {ref, onMounted, computed} from "vue";
import {orderService} from "@/service/OrderService";
import {Search} from "@/models/Search.ts";
import {formatCurrency} from "@/utils/Constant.ts";

const orders = ref<any>();
const searchText = ref("");
const page = ref<number>(1);
const size = ref<number>(10);
const totalPages = ref<number>(1);

const callSearch = async () => {
  const search = new Search(page.value, size.value, searchText.value);
  const res = await orderService.search(search);
  orders.value = res.data.data;
  totalPages.value = res.data.total || 0;
};

const onSearch = () => {
  page.value = 1;
  callSearch();
};

const onPageChange = (newPage: number) => {
  newPage = Number(newPage);
  if (newPage < 1) {
    newPage = 1;
  }

  if (newPage > totalPages.value) {
    newPage = totalPages.value;
  }

  if (newPage === page.value) {
    return;
  }

  page.value = newPage;
  callSearch();
};

onMounted(() => {
  console.log(page.value)
  callSearch();
});
</script>

<template>
  <section class="content-card" id="orders">
    <div class="card-header">
      <h2 class="card-title">📦 Quản Lý Đơn Hàng</h2>
      <div class="card-actions">
        <button class="btn btn-secondary" @click="callSearch">🔍 Tìm kiếm</button>
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
          <td>{{ o.orderCode }}</td>
          <td>{{ o.userName }}</td>
          <td>{{ o.phone }}</td>
          <td>{{ o.codeStaff }}</td>
          <td>{{ o.createdAt }}</td>
          <td>{{ o.dateTimeCheckout }}</td>
          <td>{{ o.status }}</td>
          <td>{{ o.quantity }}</td>
          <td>{{ formatCurrency(o.totalPrice) }}</td>
          <td>{{ formatCurrency(o.shippingFee) }}</td>
          <td>{{ formatCurrency(o.totalOrderAmount) }}</td>
          <td><router-link :to="`/admin/orders-detail/${o.order_id}`" class="action-btn btn-edit">✏️</router-link></td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="pagination">
      <button class="page-btn" :disabled="page === 1" @click="onPageChange(page - 1)">«</button>
      <button
          class="page-btn active"
      >
        {{ page }} / {{ totalPages}}
      </button>
      <button class="page-btn" :disabled="page >= totalPages" @click="onPageChange(page + 1)">»</button>
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

.breadcrumb a {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
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
  text-align: center;
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

.btn-edit {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: white;
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
  .table-wrapper {
    overflow-x: scroll;
  }

  table {
    min-width: 800px;
  }
}

@media (max-width: 480px) {
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
  padding: 30px;
}

.page-btn {
  width: 40px;
  height: 40px;
  border-radius: 10px;
  border: none;
  background: #f0f0f0;
  color: #1a1a2e;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
}

.page-btn:hover,
.page-btn.active {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  transform: scale(1.1);
}
.page-btn:disabled {
  background: #ddd !important;
  color: #888 !important;
  cursor: not-allowed !important;
  transform: none !important;
}

.page-btn:disabled:hover {
  background: #ddd !important;
  transform: none !important;
}
</style>