<template>
  <div class="auth-container">
    <div class="auth-card">
      <h1>Register</h1>
      <form @submit.prevent="handleRegister">
        <div class="input-field">
          <label for="username">Username:</label>
          <input id="username" v-model="username" type="text" required />
        </div>
        <div class="input-field">
          <label for="password">Password:</label>
          <input id="password" v-model="password" type="password" required />
        </div>
        <button type="submit" class="btn submit">Register</button>
      </form>
      <p v-if="errorMessage" class="error-message">⚠️ {{ errorMessage }}</p>
      <p class="auth-link">
        Already have an account?
        <router-link to="/">Login here</router-link>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data() {
    return {
      username: '',
      password: '',
      errorMessage: '',
    };
  },
  methods: {
    async handleRegister() {
      try {
        const response = await fetch('http://localhost:8080/api/auth/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            username: this.username,
            password: this.password,
          }),
        });

        if (!response.ok) {
          const errorText = await response.text();
          throw new Error(errorText || 'Registration failed');
        }

        this.$router.push('/');
      } catch (error) {
        console.error(error);
        this.errorMessage = 'Registration failed. ' + error.message;
      }
    },
  },
};
</script>

<style scoped>
.auth-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f7fb;
}

.auth-card {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 400px;
}

h1 {
  color: #2c3e50;
  text-align: center;
  margin-bottom: 1.5rem;
}

.input-field {
  margin-bottom: 1rem;
}

.input-field label {
  display: block;
  margin-bottom: 0.5rem;
  color: #4a5568;
}

.input-field input {
  width: 100%;
  padding: 0.75rem;
  border: 2px solid #e2e8f0;
  border-radius: 8px;
  font-size: 1rem;
}

.input-field input:focus {
  outline: none;
  border-color: #667eea;
}

.btn.submit {
  width: 100%;
  padding: 0.75rem;
  background-color: #667eea;
  color: white;
  border: none;
  border-radius: 8px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
}

.btn.submit:hover {
  background-color: #5a67d8;
}

.error-message {
  margin-top: 1rem;
  color: #f56565;
  text-align: center;
}

.auth-link {
  text-align: center;
  margin-top: 1rem;
  color: #4a5568;
}

.auth-link a {
  color: #667eea;
  text-decoration: none;
}

.auth-link a:hover {
  text-decoration: underline;
}
</style>