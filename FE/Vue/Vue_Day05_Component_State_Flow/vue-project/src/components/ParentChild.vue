<template>
  <div>
    <h4>자식컴포넌트</h4>
    <p>여기야!</p>
    <!-- 메세지를 페이지에 출력하는 방법은 아래의 2가지가 있다 -->
    <p>{{ myMsg }}</p>
    <p v-text="myMsg"></p>
    <!--  -->


    <p>{{ dynamicName }}</p>
    <p>{{ person }}</p>
    <hr>
    <!-- 부모에게 알림 , 카멜케이스 권장 -->
    <button @click="$emit('someEvent')">부모전송</button>
    <button @click="buttonClick">부모전송2</button>
    <button @click="emitArgs">추가인자전달</button>
    <hr>
    <!-- 여기서 손자에게 정보를 넘김
    여기서  v-bind가 들어감 -> 
   부모 컴포넌트의 myMsg 데이터를 자식 컴포넌트의 my-msg 속성으로 전달합니다. 
   v-bind 덕분에 myMsg 값이 변경될 때마다 ParentGrandChild 컴포넌트에서 
   해당 값을 실시간으로 반영 -->
    <ParentGrandChild @update-namee="updateNameee" :my-msg="myMsg"/>

  </div>
</template>

<script setup>
//부모로부터 받은 props를 사용하기 위한 방법은 크게 2가지

//방법 1
// defineProps(['myMsg']) //너무나도 심플한 받기

//방법 2 : 객체를 써라 -> 권장 방법
// 적어도 타입정도는 알려줘 더 자세히 써주면 좋고... 
const props = defineProps({
  myMsg: String,//자동으로 카멜과 케밥케이스의 형변환이 이뤄지므로 괜찮다 -> 하지만 콧수염 안에서는 안됨
  dynamicName: String,
  person: Object
});

import ParentGrandChild from './ParentGrandChild.vue';



const emit = defineEmits(["someEvent", 'emitArgss', 'updateNameeee'])
//복잡할 경우엔 메서드를 이용해서 작성을 하는것 조금 더 가독성과 작업을 하기 좋다
const buttonClick = function() {
    emit("someEvent")
}
const emitArgs = function(){
    emit('emitArgss', 1, 2, 3)
}

const updateNameee = function(namee){
    console.log(namee)
    emit('updateNameeee', namee)
}
console.log(props.myMsg)
</script>

<style scoped></style>
