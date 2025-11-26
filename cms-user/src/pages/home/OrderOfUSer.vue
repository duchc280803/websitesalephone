<script setup lang="ts">

import Header from "../../layout/Header.vue";
import Footer from "../../layout/Footer.vue";
</script>

<template>
  <Header/>
  <div class="page-wrapper">
    <div class="container"><!-- Header -->
      <header class="page-header">
        <h1>📦 Đơn Hàng Của Tôi</h1>
      </header><!-- Search & Filter -->
      <div class="filter-bar">
        <div class="search-box"><input type="text" id="searchInput" placeholder="Tìm kiếm theo mã đơn hàng hoặc tên sản phẩm..."> <span class="search-icon">🔍</span>
        </div><select class="filter-select" id="timeFilter"> <option value="all">Tất cả thời gian</option> <option value="7">7 ngày gần đây</option> <option value="30">30 ngày gần đây</option> <option value="90">3 tháng gần đây</option> </select>
      </div><!-- Tabs -->
      <div class="tabs-container">
        <div class="tabs">
          <div class="tab active" data-status="all">
            Tất cả <span class="tab-badge">12</span>
          </div>
          <div class="tab" data-status="pending">
            Chờ xác nhận <span class="tab-badge">2</span>
          </div>
          <div class="tab" data-status="processing">
            Đang xử lý <span class="tab-badge">3</span>
          </div>
          <div class="tab" data-status="shipping">
            Đang giao <span class="tab-badge">4</span>
          </div>
          <div class="tab" data-status="delivered">
            Đã giao <span class="tab-badge">2</span>
          </div>
          <div class="tab" data-status="cancelled">
            Đã hủy <span class="tab-badge">1</span>
          </div>
        </div>
      </div><!-- Orders List -->
      <div class="orders-list" id="ordersList"><!-- Order Card 1 -->
        <article class="order-card" data-status="shipping">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Phone Store Official</span>
            </div>
            <div class="order-status"><span class="status-badge status-shipping">🚚 Đang giao hàng</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  iPhone 15 Pro Max
                </div>
                <div class="product-variant">
                  Phân loại: 256GB - Xanh Titan
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  29.990.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">29.990.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-outline">📞 Liên hệ Shop</button> <button class="btn btn-primary">📄 Xem chi tiết</button>
            </div>
          </div>
        </article><!-- Order Card 2 -->
        <article class="order-card" data-status="processing">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Mobile World</span>
            </div>
            <div class="order-status"><span class="status-badge status-processing">⚙️ Đang xử lý</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  Samsung Galaxy S24 Ultra
                </div>
                <div class="product-variant">
                  Phân loại: 512GB - Đen Titanium
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  26.990.000₫
                </div>
              </div>
            </div>
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  Ốp lưng Samsung S24 Ultra
                </div>
                <div class="product-variant">
                  Phân loại: Đen - Silicone
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  350.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">27.340.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-outline">📞 Liên hệ Shop</button> <button class="btn btn-primary">📄 Xem chi tiết</button>
            </div>
          </div>
        </article><!-- Order Card 3 -->
        <article class="order-card" data-status="pending">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Tech Mobile Store</span>
            </div>
            <div class="order-status"><span class="status-badge status-pending">⏳ Chờ xác nhận</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  iPhone 14 Pro
                </div>
                <div class="product-variant">
                  Phân loại: 256GB - Tím Deep Purple
                </div>
                <div class="product-quantity">
                  Số lượng: x2
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  47.980.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">47.980.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-outline">📞 Liên hệ Shop</button> <button class="btn btn-primary">📄 Xem chi tiết</button>
            </div>
          </div>
        </article><!-- Order Card 4 -->
        <article class="order-card" data-status="delivered">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Phone Store Official</span>
            </div>
            <div class="order-status"><span class="status-badge status-delivered">✅ Đã giao hàng</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  Xiaomi 14 Ultra
                </div>
                <div class="product-variant">
                  Phân loại: 512GB - Đen
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  19.990.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">19.990.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-success">⭐ Đánh giá</button> <button class="btn btn-outline">🔄 Mua lại</button>
            </div>
          </div>
        </article><!-- Order Card 5 -->
        <article class="order-card" data-status="cancelled">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Mobile World</span>
            </div>
            <div class="order-status"><span class="status-badge status-cancelled">❌ Đã hủy</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  OPPO Find X7 Ultra
                </div>
                <div class="product-variant">
                  Phân loại: 256GB - Xanh
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  18.990.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">18.990.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-outline">🔄 Mua lại</button>
            </div>
          </div>
        </article><!-- Order Card 6 -->
        <article class="order-card" data-status="shipping">
          <div class="order-header">
            <div class="order-shop"><span class="shop-icon">🏪</span> <span>Tech Mobile Store</span>
            </div>
            <div class="order-status"><span class="status-badge status-shipping">🚚 Đang giao hàng</span>
            </div>
          </div>
          <div class="order-body">
            <div class="product-item">
              <div class="product-image">
                📱
              </div>
              <div class="product-info">
                <div class="product-name">
                  Vivo X100 Pro
                </div>
                <div class="product-variant">
                  Phân loại: 512GB - Xanh dương
                </div>
                <div class="product-quantity">
                  Số lượng: x1
                </div>
              </div>
              <div class="product-price">
                <div class="price-amount">
                  22.990.000₫
                </div>
              </div>
            </div>
          </div>
          <div class="order-footer">
            <div class="order-total"><span class="total-label">Tổng thanh toán:</span> <span class="total-amount">22.990.000₫</span>
            </div>
            <div class="order-actions"><button class="btn btn-outline">📞 Liên hệ Shop</button> <button class="btn btn-primary">📄 Xem chi tiết</button>
            </div>
          </div>
        </article>
      </div><!-- Empty State (hidden by default) -->
      <div class="empty-state" id="emptyState" style="display: none;">
        <div class="empty-icon">
          📦
        </div>
        <div class="empty-title">
          Không tìm thấy đơn hàng
        </div>
        <div class="empty-text">
          Bạn chưa có đơn hàng nào phù hợp với tiêu chí tìm kiếm
        </div>
      </div>
    </div>
  </div>
  <Footer/>
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
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  color: #1a1a2e;
  line-height: 1.6;
}

.page-wrapper {
  width: 100%;
  min-height: 100%;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 30px 20px;
  width: 100%;
}

/* Header */
.page-header {
  background: white;
  padding: 25px 30px;
  border-radius: 12px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.page-header h1 {
  font-size: 2em;
  font-weight: 700;
  color: #1a1a2e;
  display: flex;
  align-items: center;
  gap: 12px;
}

/* Search & Filter Bar */
.filter-bar {
  background: white;
  padding: 20px 25px;
  border-radius: 12px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  display: flex;
  gap: 15px;
  flex-wrap: wrap;
  align-items: center;
}

.search-box {
  flex: 1;
  min-width: 250px;
  position: relative;
}

.search-box input {
  width: 100%;
  padding: 12px 45px 12px 18px;
  border: 2px solid #e0e0e0;
  border-radius: 10px;
  font-size: 0.95em;
  transition: all 0.3s ease;
}

.search-box input:focus {
  outline: none;
  border-color: #667eea;
  box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
}

.search-icon {
  position: absolute;
  right: 15px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1.2em;
  color: #999;
}

.filter-select {
  padding: 12px 18px;
  border: 2px solid #e0e0e0;
  border-radius: 10px;
  font-size: 0.95em;
  font-weight: 600;
  cursor: pointer;
  background: white;
  transition: all 0.3s ease;
}

.filter-select:focus {
  outline: none;
  border-color: #667eea;
}

/* Tabs */
.tabs-container {
  background: white;
  border-radius: 12px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}

.tabs {
  display: flex;
  border-bottom: 2px solid #f0f0f0;
  overflow-x: auto;
  scrollbar-width: none;
}

.tabs::-webkit-scrollbar {
  display: none;
}

.tab {
  flex: 1;
  min-width: 120px;
  padding: 18px 20px;
  text-align: center;
  font-weight: 700;
  font-size: 0.95em;
  color: #666;
  cursor: pointer;
  transition: all 0.3s ease;
  border-bottom: 3px solid transparent;
  position: relative;
  white-space: nowrap;
}

.tab:hover {
  color: #667eea;
  background: #f9f9ff;
}

.tab.active {
  color: #667eea;
  border-bottom-color: #667eea;
  background: #f9f9ff;
}

.tab-badge {
  display: inline-block;
  background: #ff6b6b;
  color: white;
  font-size: 0.75em;
  padding: 2px 8px;
  border-radius: 10px;
  margin-left: 6px;
  font-weight: 700;
}

.tab.active .tab-badge {
  background: #667eea;
}

/* Order Cards */
.orders-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.order-card {
  background: white;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  transition: all 0.3s ease;
}

.order-card:hover {
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.12);
  transform: translateY(-2px);
}

.order-header {
  padding: 18px 25px;
  background: linear-gradient(135deg, #f5f7fa 0%, #e8ecf1 100%);
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 10px;
}

.order-shop {
  display: flex;
  align-items: center;
  gap: 10px;
  font-weight: 700;
  color: #1a1a2e;
}

.shop-icon {
  font-size: 1.3em;
}

.order-status {
  display: flex;
  align-items: center;
  gap: 8px;
}

.status-badge {
  padding: 6px 16px;
  border-radius: 8px;
  font-weight: 700;
  font-size: 0.85em;
}

.status-pending {
  background: #fff3cd;
  color: #856404;
}

.status-processing {
  background: #cfe2ff;
  color: #084298;
}

.status-shipping {
  background: #d1ecf1;
  color: #0c5460;
}

.status-delivered {
  background: #d4edda;
  color: #155724;
}

.status-cancelled {
  background: #f8d7da;
  color: #721c24;
}

.order-body {
  padding: 0;
}

.product-item {
  padding: 20px 25px;
  border-bottom: 1px solid #f0f0f0;
  display: flex;
  gap: 20px;
  align-items: center;
}

.product-item:last-child {
  border-bottom: none;
}

.product-image {
  width: 100px;
  height: 100px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 3em;
  flex-shrink: 0;
  box-shadow: 0 4px 12px rgba(102, 126, 234, 0.2);
}

.product-info {
  flex: 1;
  min-width: 0;
}

.product-name {
  font-weight: 700;
  font-size: 1.05em;
  color: #1a1a2e;
  margin-bottom: 6px;
}

.product-variant {
  color: #666;
  font-size: 0.9em;
  margin-bottom: 8px;
}

.product-quantity {
  color: #999;
  font-size: 0.9em;
}

.product-price {
  text-align: right;
  flex-shrink: 0;
}

.price-amount {
  font-size: 1.3em;
  font-weight: 800;
  color: #667eea;
}

.order-footer {
  padding: 20px 25px;
  background: #fafafa;
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 15px;
}

.order-total {
  display: flex;
  align-items: center;
  gap: 12px;
}

.total-label {
  color: #666;
  font-size: 0.95em;
}

.total-amount {
  font-size: 1.5em;
  font-weight: 800;
  color: #ff6b6b;
}

.order-actions {
  display: flex;
  gap: 10px;
  flex-wrap: wrap;
}

.btn {
  padding: 10px 20px;
  border: none;
  border-radius: 8px;
  font-weight: 700;
  font-size: 0.9em;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 6px;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 15px rgba(102, 126, 234, 0.4);
}

.btn-outline {
  background: white;
  color: #667eea;
  border: 2px solid #667eea;
}

.btn-outline:hover {
  background: #667eea;
  color: white;
}

.btn-success {
  background: #43e97b;
  color: white;
}

.btn-success:hover {
  background: #38d96b;
}

/* Empty State */
.empty-state {
  text-align: center;
  padding: 80px 20px;
  background: white;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.empty-icon {
  font-size: 6em;
  margin-bottom: 20px;
}

.empty-title {
  font-size: 1.5em;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 10px;
}

.empty-text {
  color: #666;
  margin-bottom: 25px;
}

/* Responsive */
@media (max-width: 768px) {
  .container {
    padding: 20px 10px;
  }

  .page-header {
    padding: 20px;
  }

  .page-header h1 {
    font-size: 1.5em;
  }

  .filter-bar {
    padding: 15px;
  }

  .tabs {
    overflow-x: auto;
  }

  .tab {
    min-width: 100px;
    padding: 15px 10px;
    font-size: 0.85em;
  }

  .product-item {
    flex-direction: column;
    align-items: flex-start;
  }

  .product-image {
    width: 80px;
    height: 80px;
    font-size: 2.5em;
  }

  .product-price {
    text-align: left;
    width: 100%;
  }

  .order-footer {
    flex-direction: column;
    align-items: flex-start;
  }

  .order-actions {
    width: 100%;
  }

  .btn {
    flex: 1;
    justify-content: center;
  }
}
</style>