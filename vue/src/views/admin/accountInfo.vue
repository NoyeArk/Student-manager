<template v-slot="scope">

  <div>
    <div style="margin-left: 120px; margin-top: 40px">
      <span style="font-size: 20px; font-weight: bold">账号信息</span>
    </div>

    <el-descriptions style="width: 300px; margin-left: 300px; margin-right: 120px; margin-top: 30px;" :column="1" :size="'medium'" border>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-user"></i>
          用户名
        </template>
        {{form.username}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          账号
        </template>
        {{form.account}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          密码
        </template>
        {{form.password}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 80px">
        <template slot="label">
          <i class="el-icon-location-outline"></i>
          手机号
        </template>
        {{form.phone}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-location-outline"></i>
          邮箱
        </template>
        {{form.email}}
      </el-descriptions-item>

    </el-descriptions>

    <el-button type="primary" style="margin-left: 400px; ; margin-top: 30px" @click="jump(form.account)">修改信息</el-button>

<!--    <el-popconfirm-->
<!--        title="确定重置密码为123吗？"-->
<!--        @confirm="reset">-->
<!--      <el-button type="danger" slot="reference" style="margin-left: 15px; margin-right: 400px">重置密码</el-button>-->
<!--    </el-popconfirm>-->

  </div>

</template>

<style>

.custom-title {
  font-size: 16px; /* 标题字体大小 */
}

</style>

<script>
import request from "@/utils/request";
import global_ from "@/components/Global";

export default {
  name: 'accountInfo',

  data() {
    return {
      form: {},
      data: {}
    }
  },

  created() {
    // 读取全局变量的值
    // const cookies = document.cookie.split('; ');
    // for (let i = 0; i < cookies.length; i++) {
    //   const cookie = cookies[i].split('=');
    //   if (cookie[0] === 'myVariable') {
    //     const storedValue = cookie[1];
    //     // 处理存储的值
    //     console.log(storedValue)
    //     break;
    //   }
    // }

    // 读取全局变量的值
    // const storedValue = JSON.parse(localStorage.getItem('myVariable'));

    // this.$notify.success("这里是accountInfo的构造函数")
    const account = global_.adminAccount
    request.get('/admin/list').then(res => {
      if (res.code === '1') {
        for (let i = 0; i < res.data.length; i++) {
          if (res.data[i].account === account) {
            this.form = res.data[i]
            break
          }
        }
        // console.log(this.form)
      }
    })
  },

  methods: {
    jump(account) {
      this.$router.push('/editAdmin?account=' + account)
    },
  }
}

</script>

<style scoped>

</style>