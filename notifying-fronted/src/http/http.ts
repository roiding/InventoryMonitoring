import axios from "axios";

//开始配置axios
const service = axios.create({
  baseURL: 'http://'+import.meta.env.SERVE_URL+'/api' as string,
  timeout: 50000,
});
debugger;
//axios.defaults.withCredentials=true;
// // 请求拦截器，设置token
// service.interceptors.request.use(
//   (config) => {
//     let token = store.getters.getToken;
//     if (token != "") {
//       token && (config.headers.Authorization = token);
//     }
//     return config;
//   },
//   (error) => {
//     // 可以安装elementui等ui组件，将错误信息输出到界面。
//     console.log(error);
//     return Promise.reject(error);
//   }
// );
// 响应拦截器
service.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      if (response.data.state == undefined) {
        //不是一个ajax回复,目前是文件下载
        return Promise.resolve(response);
        // 993登录过期
      } else if (response.data.state == "200") {
        return Promise.resolve(response);
      } else if (response.data.state != "993") {
        ElMessage.error(response.data.error);
        return Promise.reject(response);
      } else {
        ElMessage.error(response.data.error);
        // store.commit("cleanLogin"); // 使用vuex存储过用户信息，这里需要清空一下。
        // window.location.href = "/";
      }
    } else {
      ElMessage.error("请联系管理员,错误原因" + response);
      return Promise.reject(response);
    }
    //处理网络问题
  },
  (error) => {
    if (!error.response) {
      ElMessage.error("无网络或后台正在更新，请稍后再试！");
    } else {
      ElMessage.error({
        message: "请联系管理员,错误原因<br/>" + error,
        dangerouslyUseHTMLString: true,
      });
    }

    return Promise.reject(error);
  }
);

export default service;
