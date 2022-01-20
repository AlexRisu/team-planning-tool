import Vue from 'vue'
import App from './App.vue'
import axios from 'axios';
import vuetify from "@/plugins/vuetify";
import router from './router';

Vue.prototype.$http = axios.create({
    baseURL: process.env.VUE_APP_BASE_URL,
});

Vue.config.productionTip = false

new Vue({
    vuetify,
    router,
    render: h => h(App)
}).$mount('#app')
