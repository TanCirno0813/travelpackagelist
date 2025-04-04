<!-- src/components/Footer.vue -->
<template>
  <footer class="footer">
    <div class="footer-container">
      <!-- 로고 및 설명 -->
      <div>
        <h3>🌍 여행 플랫폼</h3>
        <p>
          더 나은 여행을 위한 스마트한 선택,<br />
          여행 플랫폼과 함께하세요.
        </p>
      </div>

      <!-- 바로가기 -->
      <div>
        <h4>바로가기</h4>
        <ul>
          <li><a href="/terms">이용약관</a></li>
          <li><a href="/privacy">개인정보처리방침</a></li>
          <li><a href="/board">게시판</a></li>
          <li><a href="/admin">관리자 페이지</a></li>
        </ul>
      </div>

      <!-- 고객센터 -->
      <div>
        <h4>고객센터</h4>
        <p>☎ 1234-5678</p>
        <p>이메일: help@travel.com</p>
        <p>운영시간: 평일 09:00 ~ 18:00</p>
      </div>
    </div>

    <div class="footer-bottom">
      <p>© 2025 Travel Platform. All rights reserved.</p>
    </div>
  </footer>
</template>

<style scoped>
.footer {
  background-color: #f9f9f9;
  border-top: 1px solid #ddd;
  padding: 40px 0;
  font-size: 14px;
  color: #666;
}
.footer-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
}
.footer-container h3 {
  font-size: 20px;
  color: #028267;
}
.footer-container h4 {
  font-weight: bold;
  margin-bottom: 10px;
}
.footer-container ul {
  list-style: none;
  padding: 0;
  line-height: 2;
}
.footer-bottom {
  text-align: center;
  margin-top: 30px;
  color: #aaa;
}
</style>
