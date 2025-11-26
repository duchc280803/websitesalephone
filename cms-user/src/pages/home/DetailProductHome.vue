<script setup lang="ts">

import HomeLayout from "../../layout/Header.vue";
import Footer from "../../layout/Footer.vue";
</script>

<template>
  <HomeLayout/>
  <nav class="breadcrumb"><a href="#home">Trang chủ</a> <span>/</span> <a href="#products">Sản phẩm</a> <span>/</span>
    <a href="#smartphones">Điện thoại</a> <span>/</span> <span>iPhone 15 Pro Max</span>
  </nav><!-- Product Detail -->
  <article class="product-detail">
    <div class="product-grid"><!-- Image Gallery -->
      <section class="image-gallery">
        <div class="main-image">
          📱
        </div>
        <div class="thumbnail-grid">
          <div class="thumbnail active">
            📱
          </div>
          <div class="thumbnail">
            📷
          </div>
          <div class="thumbnail">
            🔋
          </div>
          <div class="thumbnail">
            📐
          </div>
        </div>
      </section><!-- Product Info -->
      <section class="product-info"><span class="product-badge">🔥 HOT DEAL</span>
        <h1 class="product-title">iPhone 15 Pro Max</h1>
        <div class="rating">
          <div class="stars">
            ★★★★★
          </div>
          <span class="review-count">(1,234 đánh giá)</span>
        </div>
        <div class="stock-status"><span class="stock-dot"></span> Còn hàng - Giao hàng nhanh
        </div>
        <div class="price-section">
          <div class="current-price">
            29.990.000₫
          </div>
          <div><span class="original-price">34.990.000₫</span> <span class="discount-badge">-14%</span>
          </div>
        </div><!-- Brand Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">🏢</span> Thương Hiệu
          </div>
          <div class="spec-options">
            <div class="spec-option selected">
              Apple
            </div>
            <div class="spec-option">
              Samsung
            </div>
            <div class="spec-option">
              Xiaomi
            </div>
            <div class="spec-option">
              OPPO
            </div>
            <div class="spec-option">
              Vivo
            </div>
          </div>
        </div><!-- RAM Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">💾</span> Dung Lượng RAM
          </div>
          <div class="spec-options">
            <div class="spec-option">
              6GB
            </div>
            <div class="spec-option selected">
              8GB
            </div>
            <div class="spec-option">
              12GB
            </div>
            <div class="spec-option">
              16GB
            </div>
          </div>
        </div><!-- CPU Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">⚡</span> Bộ Xử Lý (CPU)
          </div>
          <div class="spec-options">
            <div class="spec-option selected">
              Apple A17 Pro
            </div>
            <div class="spec-option">
              Snapdragon 8 Gen 3
            </div>
            <div class="spec-option">
              Dimensity 9300
            </div>
            <div class="spec-option">
              Exynos 2400
            </div>
          </div>
        </div><!-- Camera Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">📷</span> Camera Chính
          </div>
          <div class="spec-options">
            <div class="spec-option">
              48MP
            </div>
            <div class="spec-option">
              64MP
            </div>
            <div class="spec-option selected">
              108MP
            </div>
            <div class="spec-option">
              200MP
            </div>
          </div>
        </div><!-- Screen Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">📱</span> Kích Thước Màn Hình
          </div>
          <div class="spec-options">
            <div class="spec-option">
              6.1"
            </div>
            <div class="spec-option selected">
              6.7"
            </div>
            <div class="spec-option">
              6.8"
            </div>
            <div class="spec-option">
              7.0"
            </div>
          </div>
        </div><!-- Color Selection -->
        <div class="spec-section">
          <div class="spec-label"><span class="spec-icon">🎨</span> Màu Sắc
          </div>
          <div class="color-options">
            <div class="color-option color-black" title="Đen"></div>
            <div class="color-option color-white" title="Trắng"></div>
            <div class="color-option color-blue selected" title="Xanh Dương"></div>
            <div class="color-option color-purple" title="Tím"></div>
            <div class="color-option color-gold" title="Vàng"></div>
            <div class="color-option color-green" title="Xanh Lá"></div>
            <div class="color-option color-red" title="Đỏ"></div>
          </div>
        </div><!-- Key Features -->
        <div class="features-grid">
          <div class="feature-item">
            <div class="feature-icon">
              📱
            </div>
            <div class="feature-text">
              <div class="feature-label">
                Màn hình
              </div>
              <div class="feature-value">
                OLED 6.7" 120Hz
              </div>
            </div>
          </div>
          <div class="feature-item">
            <div class="feature-icon">
              🔋
            </div>
            <div class="feature-text">
              <div class="feature-label">
                Pin
              </div>
              <div class="feature-value">
                4422 mAh
              </div>
            </div>
          </div>
          <div class="feature-item">
            <div class="feature-icon">
              💾
            </div>
            <div class="feature-text">
              <div class="feature-label">
                Bộ nhớ
              </div>
              <div class="feature-value">
                256GB
              </div>
            </div>
          </div>
          <div class="feature-item">
            <div class="feature-icon">
              ⚡
            </div>
            <div class="feature-text">
              <div class="feature-label">
                Sạc nhanh
              </div>
              <div class="feature-value">
                27W
              </div>
            </div>
          </div>
        </div><!-- Action Buttons -->
        <div class="action-buttons">
          <button class="btn btn-primary"> 🛒 Thêm Vào Giỏ Hàng</button>
          <button class="btn btn-secondary"> ❤️ Yêu Thích</button>
        </div>
      </section>
    </div><!-- Description -->
    <section class="description-section">
      <h2 class="description-title">📝 Mô Tả Sản Phẩm</h2>
      <p class="description-text"><strong>iPhone 15 Pro Max</strong> là chiếc smartphone cao cấp nhất trong dòng iPhone
        15 Series của Apple, mang đến trải nghiệm đỉnh cao với chip A17 Pro mạnh mẽ, hệ thống camera tiên tiến và thiết
        kế titan cao cấp.</p>
      <p class="description-text">Màn hình Super Retina XDR 6.7 inch với công nghệ ProMotion 120Hz cho hình ảnh mượt mà,
        sống động với độ sáng tối đa lên đến 2000 nits. Chip A17 Pro được sản xuất trên tiến trình 3nm mang lại hiệu
        năng vượt trội và tiết kiệm điện năng tối ưu.</p>
      <p class="description-text">Hệ thống camera chuyên nghiệp với cảm biến chính 48MP, khả năng zoom quang học 5x, chế
        độ chụp đêm nâng cao và quay video ProRes 4K. Pin 4422mAh đi kèm sạc nhanh 27W và sạc không dây MagSafe 15W.</p>
      <p class="description-text">Thiết kế khung titan cao cấp, chống nước IP68, hỗ trợ 5G và Dynamic Island thông minh.
        Sản phẩm đi kèm với hộp đựng, cáp sạc USB-C và các phụ kiện chính hãng Apple.</p>
    </section>
  </article>
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
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: #1a1a2e;
  line-height: 1.6;
  padding: 40px 20px;
}

.container {
  max-width: 1400px;
  margin: 0 auto;
}

/* Breadcrumb */
.breadcrumb {
  background: white;
  padding: 20px 30px;
  border-radius: 15px;
  margin-bottom: 30px;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.08);
}

.breadcrumb a {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
  transition: all 0.3s ease;
}

.breadcrumb a:hover {
  color: #764ba2;
}

.breadcrumb span {
  color: #666;
  margin: 0 10px;
}

/* Product Detail Card */
.product-detail {
  background: white;
  border-radius: 25px;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.product-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 60px;
  padding: 50px;
}

/* Image Gallery */
.image-gallery {
  position: sticky;
  top: 20px;
}

.main-image {
  width: 100%;
  height: 500px;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 180px;
  margin-bottom: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease;
}

.main-image:hover {
  transform: scale(1.02);
}

.thumbnail-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 15px;
}

.thumbnail {
  width: 100%;
  height: 100px;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 40px;
  cursor: pointer;
  transition: all 0.3s ease;
  border: 3px solid transparent;
}

.thumbnail:hover,
.thumbnail.active {
  border-color: #667eea;
  transform: translateY(-3px);
  box-shadow: 0 5px 15px rgba(102, 126, 234, 0.3);
}

/* Product Info */
.product-info {
  padding: 20px 0;
}

.product-badge {
  display: inline-block;
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: white;
  padding: 8px 20px;
  border-radius: 20px;
  font-size: 0.9em;
  font-weight: 700;
  margin-bottom: 15px;
}

.product-title {
  font-size: 2.5em;
  font-weight: 800;
  color: #1a1a2e;
  margin-bottom: 15px;
  line-height: 1.2;
}

.rating {
  display: flex;
  align-items: center;
  gap: 15px;
  margin-bottom: 25px;
}

.stars {
  color: #ffd700;
  font-size: 1.3em;
  letter-spacing: 3px;
}

.review-count {
  color: #666;
  font-size: 1em;
}

.price-section {
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  padding: 25px;
  border-radius: 15px;
  margin-bottom: 30px;
}

.current-price {
  font-size: 2.5em;
  font-weight: 800;
  color: #667eea;
  margin-bottom: 5px;
}

.original-price {
  font-size: 1.3em;
  color: #999;
  text-decoration: line-through;
  margin-right: 15px;
}

.discount-badge {
  display: inline-block;
  background: linear-gradient(135deg, #ff6b6b 0%, #ee5a6f 100%);
  color: white;
  padding: 5px 15px;
  border-radius: 15px;
  font-size: 0.9em;
  font-weight: 700;
}

/* Specifications Options */
.spec-section {
  margin-bottom: 35px;
}

.spec-label {
  font-size: 1.1em;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 15px;
  display: flex;
  align-items: center;
  gap: 8px;
}

.spec-icon {
  font-size: 1.3em;
}

.spec-options {
  display: flex;
  flex-wrap: wrap;
  gap: 12px;
}

.spec-option {
  padding: 12px 24px;
  border: 2px solid #e0e0e0;
  border-radius: 12px;
  background: white;
  cursor: pointer;
  transition: all 0.3s ease;
  font-weight: 600;
  font-size: 0.95em;
  color: #666;
}

.spec-option:hover {
  border-color: #667eea;
  color: #667eea;
  transform: translateY(-2px);
  box-shadow: 0 5px 15px rgba(102, 126, 234, 0.2);
}

.spec-option.selected {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border-color: #667eea;
  box-shadow: 0 5px 20px rgba(102, 126, 234, 0.4);
}

/* Color Options */
.color-options {
  display: flex;
  gap: 15px;
}

.color-option {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  cursor: pointer;
  transition: all 0.3s ease;
  border: 3px solid transparent;
  position: relative;
}

.color-option:hover {
  transform: scale(1.15);
}

.color-option.selected {
  border-color: #1a1a2e;
  box-shadow: 0 5px 20px rgba(0, 0, 0, 0.3);
}

.color-option.selected::after {
  content: '✓';
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-weight: 800;
  font-size: 1.3em;
  text-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
}

.color-black {
  background: linear-gradient(135deg, #434343 0%, #000000 100%);
}

.color-white {
  background: linear-gradient(135deg, #ffffff 0%, #f0f0f0 100%);
  border: 2px solid #ddd;
}

.color-blue {
  background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);
}

.color-purple {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.color-gold {
  background: linear-gradient(135deg, #f7ce68 0%, #fbab7e 100%);
}

.color-green {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
}

.color-red {
  background: linear-gradient(135deg, #ff6b6b 0%, #ee5a6f 100%);
}

/* Key Features */
.features-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
  margin: 30px 0;
  padding: 25px;
  background: #f9f9f9;
  border-radius: 15px;
}

.feature-item {
  display: flex;
  align-items: center;
  gap: 12px;
}

.feature-icon {
  font-size: 2em;
  width: 50px;
  height: 50px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 12px;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-shrink: 0;
}

.feature-text {
  flex: 1;
}

.feature-label {
  font-size: 0.85em;
  color: #666;
  margin-bottom: 2px;
}

.feature-value {
  font-weight: 700;
  color: #1a1a2e;
  font-size: 1.05em;
}

/* Action Buttons */
.action-buttons {
  display: flex;
  gap: 15px;
  margin-top: 40px;
}

.btn {
  flex: 1;
  padding: 18px 35px;
  border-radius: 15px;
  border: none;
  font-weight: 700;
  font-size: 1.1em;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  box-shadow: 0 5px 20px rgba(102, 126, 234, 0.4);
}

.btn-primary:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 30px rgba(102, 126, 234, 0.5);
}

.btn-secondary {
  background: white;
  color: #667eea;
  border: 2px solid #667eea;
}

.btn-secondary:hover {
  background: #667eea;
  color: white;
}

/* Stock Status */
.stock-status {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  padding: 10px 20px;
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
  color: white;
  border-radius: 12px;
  font-weight: 700;
  margin-bottom: 20px;
}

.stock-dot {
  width: 10px;
  height: 10px;
  background: white;
  border-radius: 50%;
  animation: pulse 2s infinite;
}

@keyframes pulse {
  0%, 100% {
    opacity: 1;
  }
  50% {
    opacity: 0.5;
  }
}

/* Description Section */
.description-section {
  padding: 40px 50px;
  border-top: 2px solid #f0f0f0;
}

.description-title {
  font-size: 1.8em;
  font-weight: 800;
  color: #1a1a2e;
  margin-bottom: 20px;
}

.description-text {
  color: #666;
  font-size: 1.05em;
  line-height: 1.8;
  margin-bottom: 15px;
}

/* Responsive */
@media (max-width: 1024px) {
  .product-grid {
    grid-template-columns: 1fr;
    gap: 40px;
    padding: 30px;
  }

  .image-gallery {
    position: relative;
  }

  .main-image {
    height: 400px;
    font-size: 140px;
  }

  .features-grid {
    grid-template-columns: 1fr;
  }
}

@media (max-width: 768px) {
  body {
    padding: 20px 10px;
  }

  .product-title {
    font-size: 1.8em;
  }

  .current-price {
    font-size: 2em;
  }

  .main-image {
    height: 300px;
    font-size: 100px;
  }

  .thumbnail-grid {
    grid-template-columns: repeat(4, 1fr);
    gap: 10px;
  }

  .thumbnail {
    height: 70px;
    font-size: 30px;
  }

  .action-buttons {
    flex-direction: column;
  }

  .spec-option {
    padding: 10px 18px;
    font-size: 0.9em;
  }

  .description-section {
    padding: 30px 20px;
  }
}
</style>