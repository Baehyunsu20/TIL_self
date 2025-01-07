import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import UserView from '@/views/UserView.vue'
import LoginView from '@/views/LoginView.vue'
import BoardView from '@/views/BoardView.vue'
import BoardList from '@/components/board/BoardList.vue'
import BoardCreate from '@/components/board/BoardCreate.vue'

const isAuth = true  //false : 로그인이 안되었음

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  //메인 화면에서의 큰 view, 이름을 설정해줌 -> 그냥 경로를 쓰는것이 좋다.
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView,
    },
    {
      path: '/user/:id', //동적라우팅
      name: 'user',
      component: UserView,
    },
    {
      //이미 로그인 한 상태하면 loginview로의 진입을 막고
      // home view로 이동시키기 -> url 로도 접근이 안됨
      path: '/login', //동적라우팅
      name: 'login',
      component: LoginView,
      beforeEnter: (to, from) =>{
        if(isAuth) {
          console.log("이미 로그인이 된 상태")
          return {name : 'home'}
        }
      }
    },
    {
      path: '/board',
      name: 'board',
      component: BoardView,
      children: [
        {
          path:'',
          name: 'boardList',
          component: BoardList
        },
        {
          path:'create',//슬래쉬 넣으면 에러난다.
          name: 'boardCreate',
          component: BoardCreate
        }
      ]
    }
  ],
})

router.beforeEach((to, from)=>{
  // console.log(to)
  // console.log(from)
 
  // const isAuth = true
  if(!isAuth && to.name !== 'login'){
    console.log("로그인이 필요합니다.")
    return {name : 'login'}
  }


})

export default router
