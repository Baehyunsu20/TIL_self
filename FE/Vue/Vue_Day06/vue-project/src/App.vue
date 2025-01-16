<template>
  <!-- app.vue라는 큰 화면에 views 요소들이 커다란 화면이 되고,
  그 안에 또 cpmponent들이 요소로 들어간다. -->
  <div>
    <h2>App.vue</h2>
    <nav>

      <!-- to : 개발자 도구에서는 해당 태그가 a태그 -->
      <RouterLink to="/">Home!!!</RouterLink> |
      <RouterLink to="/about">about</RouterLink> |
      <!-- url 보다는 이름을 부여하는 것이 좋다. -->
      <RouterLink :to="{name: 'home'}">HomeName</RouterLink> |
      <RouterLink :to="{name: 'about'}">aboutName</RouterLink> |
      <RouterLink :to="{name: 'user', params: {id:'happy'}}">양현수</RouterLink> |
      <RouterLink :to="{name: 'user', params: {id:'ssafy'}}">김싸피</RouterLink> | 
      <RouterLink :to="{name: 'login'}">로그인</RouterLink> | 
      <RouterLink :to="{name: 'board'}">board</RouterLink> |
    </nav>
    <p>해당위치는 어디 : 여기 "아래"에 라우터가 어디 보일지 표기</p>
    <RouterView/>
  </div>
</template>

<script setup>
 // 아래 코드를 안써줘도 전역으로 이미 선언되어있어서 괜찮다.
 // import { RouterLink, RouterView } from 'vue-router';
</script>

<style scoped>

</style>
