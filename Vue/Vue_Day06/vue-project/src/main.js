//이 부분은 app.vue의 스크립트 태그라고 보면 좋을 것 같음
import { createApp } from 'vue'
import App from './App.vue'
//index.js를 읽어서 라우터를 가져오고 그것을 아래의 앱에서 사용
import router from './router'

const app = createApp(App)

//위에서 임포트 해온 것을 use로 추가해줌
app.use(router)

app.mount('#app')
