<template>
  <div>
    <h3>UserView</h3>
    <!-- url로 입력한 값을 뜯어옴 -->
    <!-- 아래와 같이 바로 접근이 되기는 하지만... 권장은 x -->
    <p>{{ $route.params.id }}</p>
    <!-- 아래의 방식으로 사용하는 것을 권장 -->
    <p>{{ userId }}</p>
    <p>{{ userId2 }}</p>

    <hr>
    <!-- 뒤로 가기 버튼 -->
    <button @click="goHome">홈으로</button>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from 'vue-router';

  const route = useRoute()
  const router = useRouter()

  
  const userId = ref(route.params.id)
  const userId2 = ref(route.params.id)
  // 내가 감시하는 친구를 명시 = params.id가 쓰여진 url를 감시
  watch(()=>route.params.id,(newId)=>{
    //새로운 아이디가 넘어오고 userId에 newId를 넣어준다.
    userId.value = newId
  })

  const goHome = function() {
    //직접 URL 경로를 작성할 수 있음.
    router.push('/') //뒤로 가기 가능
    //뒤로 가기를 했을 때 기존의 user 페이지로 이동
    // 이름으로 호출도 할 수 있음
    // router.push({name: 'about'})
    // 유저 페이지에서 replace로 뒤로 가기를 했다면 user 페이지가 아닌 
    // 그 전전 페이지로 이동
    // router.replace({name: 'home'})//뒤로 가기 안됨
  }

  onBeforeRouteLeave(()=>{
    //window.confirm
    const answer = confirm("정말로 떠나실 건가요?")
    console.log(answer)
    // if(!answer) return false
    return answer
  })

  onBeforeRouteUpdate((to)=>{
    // 새롭게 이동할 정보 = to
    //watch를 쓰지 않더라도 이동이 된다.
    userId2.value = to.params.id
  })

</script>

<style scoped>

</style>
