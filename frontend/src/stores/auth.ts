// 간단한 로그인 검증 예시
import { defineStore } from 'pinia'
import { mockUsers } from '../data/mockUsers'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    token: null,
    username: '',
    name: '',
    role: '',
    isAuthenticated: false
  }),
  actions: {
    login(username, password) {
      const user = mockUsers.find(u => u.username === username && u.password === password)

      if (user) {
        this.token = 'dummy-token' // 실제 JWT와는 다름
        this.username = user.username
        this.name = user.name
        this.role = user.role
        this.isAuthenticated = true
        return true
      } else {
        return false
      }
    },
    logout() {
      this.token = null
      this.username = ''
      this.name = ''
      this.role = ''
      this.isAuthenticated = false
    }
  }
})
