import { createApp } from 'vue'
import './assets/main.css' // 기존 style.css 경로
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import { createPinia } from 'pinia' // ✅ Pinia import
const app = createApp(App)

const pinia = createPinia()        // ✅ Pinia 인스턴스 생성
app.use(pinia)                     // ✅ 앱에 등록
app.use(router)
app.mount('#app')
createApp(App).use(router).mount('#app')
