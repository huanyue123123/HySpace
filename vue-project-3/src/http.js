import Axios from 'axios'
import Vue from 'vue'
import router from "./router";

// 超时时间
Axios.defaults.timeout = 5000
// 添加请求拦截器
axios.interceptors.request.use(function (config) {
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});
// 添加响应拦截器
axios.interceptors.response.use(
    function (res) {
        // 返回成功可以直接打印res拿到成功数据
        if(res.data.code === 501){
            // Vue.prototype.$message({
            //     type: 'error',
            //     message: res.data.message
            // });
            router.replace({path: '/login'})
        }


        return res
    },
    function (error) {
        // 用到了es6语法 等于 response=error.response 这里错误返回直接打印error打印不到 得获取err.response才可以
        const {response = {}} = error

        const status = response.status
        switch (status) {
            case 501:
                Vue.prototype.$message({
                    type: 'error',
                    message: response.data,
                    duration: 1000
                })
                break
            default:
                //router.replace({path: '/login'})
        }
        return Promise.reject(error)
    }
)