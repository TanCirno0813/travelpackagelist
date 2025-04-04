<template>
  <div class="container mt-5">
    <h1 class="text-center mb-4">상세 페이지</h1>

    <div v-if="error" class="alert alert-warning mt-4">
      <p>해당 패키지를 찾을 수 없습니다.</p>
    </div>

    <div v-else-if="packageData" class="card">
      <div class="card-body">
        <h2 class="card-title">{{ packageData.title }}</h2>
        <img
            :src="packageData.imageUrl"
            alt="패키지 이미지"
            class="card-img-top"
        />
        <p class="card-text mb-3">{{ packageData.description }}</p>
        <p class="h4">
          가격: {{ packageData.price.toLocaleString() }} 원
        </p>
        <p class="date-field">
          날짜: {{ packageData.date }}
        </p>
      </div>
    </div>

    <div class="mt-4 text-center">
      <router-link to="/" class="btn btn-primary">메인 페이지로 돌아가기</router-link>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

export default {
  setup() {
    const route = useRoute();
    const id = route.params.id  // ✅ id를 여기서 꺼내야 함
    const packageData = ref(null);
    const error = ref(false);

    onMounted(async () => {
      try {

        const response = await axios.get(`http://localhost:8000/api/packages/detail/${id}`);
        packageData.value = response.data;
      } catch (err) {
        console.error("데이터 로드 실패:", err);
        error.value = true;
      }
    });

    return { packageData, error };
  },
};
</script>

<style scoped>
.container {
  max-width: 800px;
}

.card {
  margin-top: 20px;
}


.card-img-top {
  width: 300px;
  height: 200px;
  object-fit: cover;
  border-radius: 5px;
}


.date-field {
  font-weight: bold;
  color: #666;
  margin-top: 10px;
}
</style>
