<script setup lang="ts">

import HomeLayout from "../../layout/Header.vue";
import Footer from "../../layout/Footer.vue";
</script>

<template>
  <HomeLayout/>
  <div class="container"><!-- Page Header -->
    <header class="page-header">
      <h1>📱 Danh Sách Sản Phẩm</h1>
      <div class="breadcrumb"><a href="#home">Trang chủ</a> / Sản phẩm
      </div><!-- Search & Filter -->
      <div class="search-section">
        <div class="search-box"><input type="text" class="search-input" placeholder="Tìm kiếm sản phẩm..."> <span
            class="search-icon">🔍</span>
        </div>
        <div class="filter-group"><select class="filter-select">
          <option>Tất cả thương hiệu</option>
          <option>Apple</option>
          <option>Samsung</option>
          <option>Xiaomi</option>
          <option>OPPO</option>
        </select> <select class="filter-select">
          <option>Sắp xếp: Mới nhất</option>
          <option>Giá: Thấp đến cao</option>
          <option>Giá: Cao đến thấp</option>
          <option>Tên: A-Z</option>
          <option>Đánh giá cao nhất</option>
        </select>
        </div>
      </div>
    </header><!-- Results Info -->
    <div class="results-info">
      <div class="results-count">
        Hiển thị <strong>12</strong> trong tổng số <strong>48</strong> sản phẩm
      </div>
      <div class="view-toggle">
        <button class="view-btn active">⊞</button>
        <button class="view-btn">☰</button>
      </div>
    </div><!-- Products Grid -->
    <div class="products-grid"><!-- Product 1 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Apple</span>
          <router-link :to="{ name: 'DetailProductHome' }">
            <h3 class="product-name">iPhone 15 Pro Max</h3>
          </router-link>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">8GB RAM</span> <span
              class="spec-tag">A17 Pro</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(128 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              29.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 2 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge">-15%</span>
        </div>
        <div class="product-info"><span class="product-category">Samsung</span>
          <h3 class="product-name">Samsung S24 Ultra</h3>
          <div class="product-specs"><span class="spec-tag">512GB</span> <span class="spec-tag">12GB RAM</span> <span
              class="spec-tag">Snapdragon 8 Gen 3</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(95 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              26.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 3 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Apple</span>
          <h3 class="product-name">iPhone 14 Pro</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">6GB RAM</span> <span
              class="spec-tag">A16 Bionic</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(203 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              23.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 4 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge new">Mới</span>
        </div>
        <div class="product-info"><span class="product-category">Xiaomi</span>
          <h3 class="product-name">Xiaomi 14 Pro</h3>
          <div class="product-specs"><span class="spec-tag">512GB</span> <span class="spec-tag">16GB RAM</span> <span
              class="spec-tag">Snapdragon 8 Gen 3</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(67 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              19.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 5 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Samsung</span>
          <h3 class="product-name">Samsung Galaxy Z Fold 5</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">12GB RAM</span> <span
              class="spec-tag">Gập</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(54 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              41.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 6 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge">-20%</span>
        </div>
        <div class="product-info"><span class="product-category">OPPO</span>
          <h3 class="product-name">OPPO Find N3</h3>
          <div class="product-specs"><span class="spec-tag">512GB</span> <span class="spec-tag">16GB RAM</span> <span
              class="spec-tag">Gập</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐</span> <span class="rating-text">(42 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              35.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 7 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Apple</span>
          <h3 class="product-name">iPhone 13</h3>
          <div class="product-specs"><span class="spec-tag">128GB</span> <span class="spec-tag">4GB RAM</span> <span
              class="spec-tag">A15 Bionic</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(457 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              16.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 8 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge new">Mới</span>
        </div>
        <div class="product-info"><span class="product-category">Xiaomi</span>
          <h3 class="product-name">Xiaomi 13T Pro</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">12GB RAM</span> <span
              class="spec-tag">Dimensity 9200+</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐</span> <span class="rating-text">(89 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              12.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 9 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Samsung</span>
          <h3 class="product-name">Samsung Galaxy A54</h3>
          <div class="product-specs"><span class="spec-tag">128GB</span> <span class="spec-tag">8GB RAM</span> <span
              class="spec-tag">Exynos 1380</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐</span> <span class="rating-text">(234 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              9.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 10 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge">-10%</span>
        </div>
        <div class="product-info"><span class="product-category">OPPO</span>
          <h3 class="product-name">OPPO Reno 10 Pro</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">12GB RAM</span> <span
              class="spec-tag">Snapdragon 778G</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐</span> <span class="rating-text">(156 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              11.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 11 -->
      <article class="product-card">
        <div class="product-image">
          📱
        </div>
        <div class="product-info"><span class="product-category">Xiaomi</span>
          <h3 class="product-name">Redmi Note 13 Pro</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">8GB RAM</span> <span
              class="spec-tag">Snapdragon 7s Gen 2</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐</span> <span class="rating-text">(312 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              7.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article><!-- Product 12 -->
      <article class="product-card">
        <div class="product-image">
          📱 <span class="product-badge new">Mới</span>
        </div>
        <div class="product-info"><span class="product-category">Samsung</span>
          <h3 class="product-name">Samsung Galaxy S23</h3>
          <div class="product-specs"><span class="spec-tag">256GB</span> <span class="spec-tag">8GB RAM</span> <span
              class="spec-tag">Snapdragon 8 Gen 2</span>
          </div>
          <div class="product-rating"><span class="stars">⭐⭐⭐⭐⭐</span> <span class="rating-text">(178 đánh giá)</span>
          </div>
          <div class="product-footer">
            <div class="product-price">
              18.990.000₫
            </div>
            <button class="btn-add-cart">🛒 Thêm</button>
          </div>
        </div>
      </article>
    </div><!-- Pagination -->
    <div class="pagination">
      <button class="page-btn" disabled>⟨⟨ Đầu</button>
      <button class="page-btn" disabled>⟨ Trước</button>
      <button class="page-btn active">1</button>
      <button class="page-btn">2</button>
      <button class="page-btn">3</button>
      <button class="page-btn">4</button>
      <span class="page-info">Trang 1 / 4</span>
      <button class="page-btn">Sau ⟩</button>
      <button class="page-btn">Cuối ⟩⟩</button>
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
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: #1a1a2e;
  line-height: 1.6;
  padding: 40px 20px;
}

.container {
  max-width: 1400px;
  margin: 0 auto;
}

/* Header */
.page-header {
  background: white;
  padding: 40px;
  border-radius: 20px;
  margin-bottom: 30px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
}

.page-header h1 {
  font-size: 2.8em;
  font-weight: 800;
  color: #1a1a2e;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
  gap: 15px;
}

.breadcrumb {
  color: #666;
  font-size: 1.1em;
  margin-bottom: 30px;
}

.breadcrumb a {
  color: #667eea;
  text-decoration: none;
  font-weight: 600;
}

/* Search & Filter Section */
.search-section {
  display: flex;
  gap: 20px;
  align-items: center;
  flex-wrap: wrap;
}

.search-box {
  flex: 1;
  min-width: 300px;
  position: relative;
}

.search-input {
  width: 100%;
  padding: 16px 50px 16px 20px;
  border: 2px solid #e0e0e0;
  border-radius: 15px;
  font-size: 1.1em;
  font-weight: 600;
  transition: all 0.3s ease;
}

.search-input:focus {
  outline: none;
  border-color: #667eea;
  box-shadow: 0 0 0 4px rgba(102, 126, 234, 0.1);
}

.search-icon {
  position: absolute;
  right: 20px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 1.5em;
  color: #667eea;
}

.filter-group {
  display: flex;
  gap: 15px;
  flex-wrap: wrap;
}

.filter-select {
  padding: 16px 40px 16px 20px;
  border: 2px solid #e0e0e0;
  border-radius: 15px;
  font-size: 1em;
  font-weight: 600;
  cursor: pointer;
  background: white;
  transition: all 0.3s ease;
}

.filter-select:hover,
.filter-select:focus {
  outline: none;
  border-color: #667eea;
}

.results-info {
  background: white;
  padding: 20px 30px;
  border-radius: 15px;
  margin-bottom: 30px;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  gap: 15px;
}

.results-count {
  font-size: 1.1em;
  color: #666;
  font-weight: 600;
}

.results-count strong {
  color: #667eea;
  font-size: 1.3em;
}

.view-toggle {
  display: flex;
  gap: 10px;
}

.view-btn {
  padding: 10px 15px;
  border: 2px solid #e0e0e0;
  background: white;
  border-radius: 10px;
  cursor: pointer;
  font-size: 1.2em;
  transition: all 0.3s ease;
}

.view-btn:hover,
.view-btn.active {
  background: #667eea;
  border-color: #667eea;
  color: white;
}

/* Products Grid */
.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 25px;
  margin-bottom: 40px;
}

.product-card {
  background: white;
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
  transition: all 0.4s ease;
  cursor: pointer;
}

.product-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 40px rgba(102, 126, 234, 0.3);
}

.product-image {
  height: 250px;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 80px;
  position: relative;
}

.product-badge {
  position: absolute;
  top: 15px;
  right: 15px;
  padding: 8px 15px;
  background: linear-gradient(135deg, #ff6b6b 0%, #ee5a6f 100%);
  color: white;
  border-radius: 10px;
  font-weight: 700;
  font-size: 0.85em;
}

.product-badge.new {
  background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%);
}

.product-info {
  padding: 25px;
}

.product-category {
  display: inline-block;
  padding: 5px 12px;
  background: #f0f0f0;
  border-radius: 8px;
  font-size: 0.85em;
  color: #666;
  font-weight: 600;
  margin-bottom: 12px;
}

.product-name {
  font-size: 1.3em;
  font-weight: 700;
  color: #1a1a2e;
  margin-bottom: 10px;
  line-height: 1.4;
}

.product-specs {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-bottom: 15px;
}

.spec-tag {
  padding: 4px 10px;
  background: #f9f9f9;
  border-radius: 6px;
  font-size: 0.8em;
  color: #666;
}

.product-rating {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 15px;
}

.stars {
  color: #ffd700;
  font-size: 1em;
}

.rating-text {
  color: #666;
  font-size: 0.9em;
  font-weight: 600;
}

.product-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: 15px;
  border-top: 2px solid #f0f0f0;
}

.product-price {
  font-size: 1.6em;
  font-weight: 800;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.btn-add-cart {
  padding: 12px 20px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  border: none;
  border-radius: 12px;
  font-weight: 700;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 8px;
}

.btn-add-cart:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 20px rgba(102, 126, 234, 0.4);
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

/* Empty State */
.empty-state {
  background: white;
  border-radius: 20px;
  padding: 80px 40px;
  text-align: center;
  box-shadow: 0 5px 25px rgba(0, 0, 0, 0.08);
}

.empty-icon {
  font-size: 120px;
  margin-bottom: 20px;
  opacity: 0.3;
}

.empty-title {
  font-size: 1.8em;
  font-weight: 700;
  color: #666;
  margin-bottom: 10px;
}

.empty-text {
  color: #999;
  font-size: 1.1em;
}

/* Responsive */
@media (max-width: 968px) {
  .products-grid {
    grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
    gap: 20px;
  }

  .search-section {
    flex-direction: column;
  }

  .search-box {
    width: 100%;
  }

  .filter-group {
    width: 100%;
  }

  .filter-select {
    flex: 1;
  }
}

@media (max-width: 640px) {
  body {
    padding: 20px 10px;
  }

  .page-header h1 {
    font-size: 2em;
  }

  .products-grid {
    grid-template-columns: 1fr;
  }

  .results-info {
    flex-direction: column;
    text-align: center;
  }

  .pagination {
    gap: 5px;
  }

  .page-btn {
    min-width: 40px;
    height: 40px;
    font-size: 0.9em;
  }
}
</style>