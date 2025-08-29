<template>
  <div class="container">
    <h1>📝 留言板</h1>

    <form @submit.prevent="submitMessage" class="form">
      <input
        v-model="username"
        placeholder="你的名字"
        class="input"
      />
      <input
        v-model="content"
        placeholder="留言內容"
        class="input"
      />
      <button type="submit" class="button">送出留言</button>
    </form>

    <ul class="message-list">
      <li v-for="msg in messages" :key="msg.id" class="message-card">
        <div class="message-content">
          <strong>{{ msg.username }}</strong>：{{ msg.content }}
        </div>
        <button class="delete-btn" @click="deleteMessage(msg.id)">🗑️</button>
    </li>
  </ul>

  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const username = ref('')
const content = ref('')
const messages = ref([])

const fetchMessages = async () => {
  try {
    const res = await axios.get('http://localhost:8080/api/messages')
    messages.value = res.data
  } catch (err) {
    console.error('讀取留言失敗', err)
  }
}

const submitMessage = async () => {
  try {
    await axios.post('http://localhost:8080/api/messages', {
      username: username.value,
      content: content.value
    })
    content.value = ''
    await fetchMessages()
  } catch (err) {
    console.error('新增留言失敗', err)
  }
}

const deleteMessage = async (id) => {
  try {
    await axios.delete(`http://localhost:8080/api/messages/${id}`)
    await fetchMessages()
  } catch (err) {
    console.error('刪除留言失敗', err)
  }
}


onMounted(fetchMessages)
</script>

<style scoped>
body, html {
  margin: 0;
  padding: 0;
  height: 100%;
  font-family: "Segoe UI", sans-serif;
}

.container {
  width: 90%;
  max-width: 900px;
  margin: 40px auto;
  padding: 20px;
  background: rgba(255, 255, 255, 0.9); /* 半透明白底卡片 */
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #333;
}

.form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 30px;
}

.input {
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 6px;
}

.button {
  padding: 10px;
  background-color: #42b983;
  color: white;
  font-weight: bold;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.button:hover {
  background-color: #369f6c;
}

.message-list {
  list-style: none;
  padding: 0;
  display: flex;
  flex-direction: column;
  gap: 12px;
}

.message-card {
  background-color: #f9f9f9;
  padding: 12px 16px;
  border-radius: 8px;
  border: 1px solid #e0e0e0;
  box-shadow: 0 2px 4px rgba(0,0,0,0.05);
}

.message-card {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.delete-btn {
  background-color: transparent;
  border: none;
  font-size: 18px;
  cursor: pointer;
  color: #d9534f;
  transition: color 0.2s ease;
}

.delete-btn:hover {
  color: #b52b27;
}

/* ✅ 背景天空藍 → 水藍色漸層 */
:global(body) {
  min-height: 100vh;
  background: linear-gradient(to bottom, #87CEEB, #B2EBF2);
  background-attachment: fixed;
  background-size: cover;
}
</style>
