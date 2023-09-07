import Vue from 'vue'
import App from './App.vue'
import router from './router'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/assets/global.css'

Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'small'}); //medium small min1

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

Vue.directive('title', {
  inserted: function (el, binding) {
    document.title = el.dataset.title
  }
})