

<template>
  <header class="header">
    <div class="header-container">
      <!-- 로고 + 검색창 -->
      <div class="header-left">
        <h1 class="logo">
          <a href="/">🌍 <span>여행 플랫폼</span></a>
        </h1>
        <form   class="search-form">
          <input type="text" v-model="searchKeyword" class="form-control" placeholder="여행지를 검색하세요" @keypress.enter="search">
          <button class="btn btn-primary" @click="search">검색</button>
        </form>
      </div>

      <nav class="top-nav">
        <template v-if="auth.name">
          <div class="user-welcome">
            <span><strong>{{ auth.name }}</strong> 님 환영합니다 😊</span>
          </div>
          <a href="#" @click.prevent="auth.logout()">로그아웃</a>
          <a href="/mypage">마이페이지</a>
          <a href="/admin">관리자 페이지</a>
          <a href="/board">게시판</a>
        </template>
        <template v-else>
          <a href="/login">로그인</a>
          <a href="/signup">회원가입</a>
          <a href="/board">게시판</a>
        </template>
      </nav>
    </div>
  </header>
</template>
<script setup>
import { useAuthStore } from '../stores/auth'
import { ref, computed, onMounted } from "vue";
import { useRouter } from "vue-router"
const searchKeyword = ref("");

const router = useRouter()
const auth = useAuthStore()

const search = () => {
  if (searchKeyword.value.trim() === "") {
    alert("검색어를 입력하세요")
    return
  }
  router.push({ path: "/package", query: { keyword: searchKeyword.value } })
}
</script>
<style scoped>
.header {
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
  padding: 12px 0;
}
.header-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.header-left {
  display: flex;
  align-items: center;
  gap: 20px;
}
.logo {
  font-size: 24px;
  white-space: nowrap;
  display: flex;
  align-items: center;
}

.logo span {
  margin-left: 6px;
  display: inline-block;
}
.search-form {
  display: flex;
  align-items: center;
  gap: 6px;
}
.search-form input {
  width: 360px;
  height: 36px;
  padding: 0 10px;
  border: 1px solid #ccc;
  border-radius: 6px;
}
.search-form button {
  height: 36px;
  min-width: 60px; /* ✅ 버튼 너비 확보 */
  padding: 0 12px;
  border: none;
  background-color: #028267;
  color: white;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  line-height: 1;
  font-size: 14px;
  white-space: nowrap; /* ✅ 줄바꿈 방지 */
}

.top-nav {
  display: flex;
  gap: 15px;
  font-weight: 500;
  white-space: nowrap; /* 줄바꿈 방지 */
  align-items: center;
  flex-wrap: nowrap;   /* 한 줄에 유지 */
}

.user-welcome {
  background-color: #e6f4f1;
  color: #028267;
  padding: 6px 12px;
  border-radius: 20px;
  font-weight: 500;
  display: flex;
  align-items: center;
  font-size: 14px;
  margin-right: 8px;
  transition: background-color 0.2s ease;
}

.user-welcome:hover {
  background-color: #c9e8e1;
}
</style>
