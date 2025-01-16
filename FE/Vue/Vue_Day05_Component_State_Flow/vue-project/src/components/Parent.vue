<template>
    <div>
        <h3>부모 컴포넌트</h3>
        <!-- child만 쓰지 않고 Parents랑 관련이 있음 -->
        <!-- 여기서는 카멜이 아닌 케밥케이스로 적음  -->
        <ParentChild @update-nameeee="updateNameeeee"  @some-event="someCallback" @emit-argss="getNumber"
        my-msg="아니????" :dynamic-name="name" :person="person"/>
        <!-- 자식에다가 데이터를 내려보낼거면 html 의 속성(이름 고정 아님) my-msg 케밥 케이스를 쓰자
        my-msg 라는 이름으로 자식에게 내려보냄

        부모가 내린 prop을 자식이 어떻게 받을 것인가 -> 2가지 방법

    -->
    </div>
</template>

<script setup>
    import {ref} from 'vue';
    // 절대 경로였다면 @부터 시작하지만, 자동완성을 상대 경로로 작성
    import ParentChild from './ParentChild.vue';

    const name = ref("Kim")
    const person = ref({
        name:"Yang",
        age: 45
    })

    const someCallback = function() {
        console.log("어떠한 이벤트가 발생했습니다.")
    }

    const getNumber = function(...args){
        console.log(args)
    }

    const updateNameeeee = function(newName){
        name.value = newName
    }

</script>

<style  scoped>

</style>