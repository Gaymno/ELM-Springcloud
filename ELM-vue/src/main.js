import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app = createApp(App)
//设置axios的基础url部分
axios.defaults.baseURL = 'http://www.elmservice.com:8080/';

router.beforeEach((to,from,next)=>{
    let user = sessionStorage.getItem('user');
    //除了登录、注册、首页、商家列表、商家信息之外，都需要判断是否登录
    if(!(to.path==='/'||to.path==='/index'||to.path==='/login'||to.path==='/register')){
        if(user==null){
            router.push('/login');
        }
        // location.reload();
    }
    next();
});
app.use(router)
app.use(ElementPlus)
app.mount('#app')
