<script setup lang="ts">

import Footer from "../../layout/Footer.vue";
import Header from "../../layout/Header.vue";
</script>

<template>
  <Header/>
  <div class="page-wrapper">
    <div class="container"><!-- Header -->
      <header class="page-header">
        <div class="header-left">
          <h1>📋 Chi Tiết Đơn Hàng</h1>
          <div class="order-id">
            Mã đơn hàng: #DH2024031501
          </div>
        </div>
        <button class="back-btn">← Quay lại</button>
      </header><!-- Order Status Timeline -->
      <section class="timeline-card">
        <h2 class="timeline-title">🚚 Trạng Thái Đơn Hàng</h2>
        <div class="timeline">
          <div class="timeline-progress"></div>
          <div class="timeline-step completed">
            <div class="step-icon">
              📝
            </div>
            <div class="step-label">
              Đặt hàng
            </div>
            <div class="step-time">
              15/03/2024 10:30
            </div>
          </div>
          <div class="timeline-step completed">
            <div class="step-icon">
              ✅
            </div>
            <div class="step-label">
              Xác nhận
            </div>
            <div class="step-time">
              15/03/2024 11:15
            </div>
          </div>
          <div class="timeline-step completed">
            <div class="step-icon">
              📦
            </div>
            <div class="step-label">
              Đóng gói
            </div>
            <div class="step-time">
              15/03/2024 14:20
            </div>
          </div>
          <div class="timeline-step active">
            <div class="step-icon">
              🚚
            </div>
            <div class="step-label">
              Đang giao
            </div>
            <div class="step-time">
              16/03/2024 08:00
            </div>
          </div>
          <div class="timeline-step">
            <div class="step-icon">
              🎉
            </div>
            <div class="step-label">
              Hoàn thành
            </div>
            <div class="step-time">
              Chưa cập nhật
            </div>
          </div>
          <div class="timeline-step">
            <div class="step-icon">
              ❌
            </div>
            <div class="step-label">
              Đã hủy
            </div>
            <div class="step-time">
              -
            </div>
          </div>
        </div>
      </section><!-- Main Content Grid -->
      <div class="content-grid"><!-- Left Column: Order Details -->
        <div>
          <article class="info-card">
            <h2 class="card-title">🛒 Thông Tin Đơn Hàng</h2>
            <div class="product-list">
              <div class="product-item">
                <div class="product-image">
                  📱
                </div>
                <div class="product-details">
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
                  29.990.000₫
                </div>
              </div>
            </div>
            <div class="price-summary">
              <div class="price-row"><span class="price-label">Tạm tính</span> <span
                  class="price-value">29.990.000₫</span>
              </div>
              <div class="price-row"><span class="price-label">Phí vận chuyển</span> <span
                  class="price-value">30.000₫</span>
              </div>
              <div class="price-row price-total"><span class="price-label">Tổng thanh toán</span> <span
                  class="price-value">29.520.000₫</span>
              </div>
            </div>
            <div class="action-buttons">
              <button class="btn btn-outline">📞 Liên hệ Shop</button>
              <button class="btn btn-primary">📍 Theo dõi đơn hàng</button>
            </div>
          </article>
        </div><!-- Right Column: Shipping & Payment Info -->
        <div>
          <article class="info-card">
            <h2 class="card-title">📍 Thông Tin Khác</h2><!-- Shipping Info -->
            <div class="info-section">
              <h3 class="section-subtitle">🚚 Thông tin giao hàng</h3>
              <div class="info-row"><span class="info-label">Người nhận:</span> <span
                  class="info-value">Nguyễn Văn An</span>
              </div>
              <div class="info-row"><span class="info-label">Số điện thoại:</span> <span
                  class="info-value">0901234567</span>
              </div>
              <div class="info-row"><span class="info-label">Địa chỉ:</span> <span class="info-value">123 Đường Lê Lợi, Phường Bến Nghé, Quận 1, TP. Hồ Chí Minh</span>
              </div>
            </div><!-- Delivery Info -->
            <div class="info-section">
              <h3 class="section-subtitle">💳 Thanh toán</h3>
              <div class="info-row"><span class="info-label">Phương thức:</span> <span class="payment-badge">✓ Đã thanh toán</span>
              </div>
              <div class="info-row"><span class="info-label">Hình thức:</span> <span class="info-value">Chuyển khoản ngân hàng</span>
              </div>
            </div><!-- Notes -->
            <div class="info-section">
              <h3 class="section-subtitle">📝 Ghi chú</h3>
              <div class="info-row"><span
                  class="info-value">Giao hàng giờ hành chính. Vui lòng gọi trước 15 phút.</span>
              </div>
            </div>
          </article>
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
  margin-bottom: 25px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 15px;
}

.header-left h1 {
  font-size: 1.8em;
  font-weight: 700;
  color: #1a1a2e;
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 8px;
}

.order-id {
  font-size: 0.9em;
  color: #667eea;
  font-weight: 600;
}

.back-btn {
  padding: 12px 24px;
  background: white;
  color: #667eea;
  border: 2px solid #667eea;
  border-radius: 10px;
  font-weight: 700;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 8px;
}

.back-btn:hover {
  background: #667eea;
  color: white;
}

/* Order Status Timeline */
.timeline-card {
  background: white;
  border-radius: 12px;
  padding: 35px 30px;
  margin-bottom: 25px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.timeline-title {
  font-size: 1.3em;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 30px;
  display: flex;
  align-items: center;
  gap: 10px;
}

.timeline {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  position: relative;
  padding: 0 20px;
}

.timeline::before {
  content: '';
  position: absolute;
  top: 30px;
  left: 20px;
  right: 20px;
  height: 4px;
  background: #e0e0e0;
  z-index: 0;
}

.timeline-progress {
  position: absolute;
  top: 30px;
  left: 20px;
  height: 4px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  width: 75%;
  z-index: 1;
  transition: width 0.5s ease;
}

.timeline-step {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
  z-index: 2;
  flex: 1;
}

.step-icon {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background: #e0e0e0;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.8em;
  margin-bottom: 12px;
  transition: all 0.3s ease;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.timeline-step.completed .step-icon {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  transform: scale(1.1);
}

.timeline-step.active .step-icon {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0%, 100% {
    transform: scale(1);
    box-shadow: 0 4px 12px rgba(67, 233, 123, 0.3);
  }
  50% {
    transform: scale(1.1);
    box-shadow: 0 6px 20px rgba(67, 233, 123, 0.5);
  }
}

.step-label {
  font-weight: 700;
  font-size: 0.9em;
  color: #666;
  text-align: center;
  margin-bottom: 6px;
}

.timeline-step.completed .step-label,
.timeline-step.active .step-label {
  color: #1a1a2e;
}

.step-time {
  font-size: 0.8em;
  color: #999;
  text-align: center;
}

.timeline-step.completed .step-time,
.timeline-step.active .step-time {
  color: #667eea;
  font-weight: 600;
}

/* Main Content Grid */
.content-grid {
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 25px;
  margin-bottom: 25px;
}

/* Order Info Card */
.info-card {
  background: white;
  border-radius: 12px;
  padding: 30px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
}

.card-title {
  font-size: 1.3em;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 25px;
  display: flex;
  align-items: center;
  gap: 10px;
  padding-bottom: 15px;
  border-bottom: 3px solid #f0f0f0;
}

/* Product Items */
.product-list {
  margin-bottom: 25px;
}

.product-item {
  display: flex;
  gap: 20px;
  padding: 20px;
  background: #fafafa;
  border-radius: 10px;
  margin-bottom: 15px;
  transition: all 0.3s ease;
}

.product-item:hover {
  background: #f5f5f5;
  transform: translateX(5px);
}

.product-image {
  width: 90px;
  height: 90px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2.5em;
  flex-shrink: 0;
  box-shadow: 0 4px 12px rgba(102, 126, 234, 0.2);
}

.product-details {
  flex: 1;
  min-width: 0;
}

.product-name {
  font-weight: 700;
  font-size: 1.05em;
  color: #1a1a2e;
  margin-bottom: 8px;
}

.product-variant {
  color: #666;
  font-size: 0.9em;
  margin-bottom: 6px;
}

.product-quantity {
  color: #999;
  font-size: 0.85em;
}

.product-price {
  text-align: right;
  font-size: 1.2em;
  font-weight: 800;
  color: #667eea;
  flex-shrink: 0;
}

/* Price Summary */
.price-summary {
  border-top: 2px solid #f0f0f0;
  padding-top: 20px;
}

.price-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
  font-size: 0.95em;
}

.price-label {
  color: #666;
}

.price-value {
  font-weight: 700;
  color: #1a1a2e;
}

.price-discount {
  color: #43e97b;
}

.price-total {
  border-top: 2px dashed #e0e0e0;
  padding-top: 15px;
  margin-top: 15px;
}

.price-total .price-label {
  font-size: 1.1em;
  font-weight: 700;
  color: #1a1a2e;
}

.price-total .price-value {
  font-size: 1.5em;
  color: #ff6b6b;
}

/* Shipping Info */
.info-section {
  margin-bottom: 25px;
  padding-bottom: 25px;
  border-bottom: 2px solid #f0f0f0;
}

.info-section:last-child {
  border-bottom: none;
  margin-bottom: 0;
  padding-bottom: 0;
}

.section-subtitle {
  font-weight: 700;
  font-size: 1em;
  color: #1a1a2e;
  margin-bottom: 15px;
  display: flex;
  align-items: center;
  gap: 8px;
}

.info-row {
  display: flex;
  margin-bottom: 12px;
  font-size: 0.95em;
}

.info-label {
  color: #666;
  min-width: 120px;
  flex-shrink: 0;
}

.info-value {
  color: #1a1a2e;
  font-weight: 600;
}

.payment-badge {
  display: inline-block;
  padding: 6px 14px;
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: white;
  border-radius: 8px;
  font-weight: 700;
  font-size: 0.85em;
}

.shipping-code {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  padding: 8px 14px;
  background: #f0f0f0;
  border-radius: 8px;
  font-weight: 700;
  color: #667eea;
  cursor: pointer;
  transition: all 0.3s ease;
}

.shipping-code:hover {
  background: #667eea;
  color: white;
}

/* Action Buttons */
.action-buttons {
  display: flex;
  gap: 12px;
  margin-top: 25px;
}

.btn {
  flex: 1;
  padding: 14px 24px;
  border: none;
  border-radius: 10px;
  font-weight: 700;
  font-size: 0.95em;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 20px rgba(102, 126, 234, 0.4);
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

/* Responsive */
@media (max-width: 968px) {
  .content-grid {
    grid-template-columns: 1fr;
  }

  .timeline {
    flex-wrap: wrap;
    padding: 0;
  }

  .timeline::before,
  .timeline-progress {
    display: none;
  }

  .timeline-step {
    flex-basis: 50%;
    margin-bottom: 25px;
  }
}

@media (max-width: 768px) {
  .container {
    padding: 20px 10px;
  }

  .page-header {
    padding: 20px;
  }

  .page-header h1 {
    font-size: 1.4em;
  }

  .timeline-card,
  .info-card {
    padding: 20px;
  }

  .product-item {
    flex-direction: column;
  }

  .product-price {
    text-align: left;
  }

  .action-buttons {
    flex-direction: column;
  }

  .info-row {
    flex-direction: column;
    gap: 6px;
  }

  .info-label {
    min-width: auto;
  }
}
</style>