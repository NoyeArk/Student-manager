<template>

  <div style="height: 100vh; overflow: hidden" class="background-container">

<!--    <img :src="imageSrc" alt="图片" class="image">-->

    <div style="width: 400px; height: 300px; background-color: rgba(230, 230, 250, 0.35); border-radius: 10px; margin: 150px auto; padding: 50px" @keyup.enter="login">

      <div style="margin: 1px; text-align: center; font-size: 20px; font-weight: bold; color: black">
        账号密码登录
      </div>

      <el-form :model="admin" :rules="rules" ref="loginForm" style="margin-top: 30px" >

        <el-form-item prop="account">
          <el-input placeholder="学号/工号" prefix-icon="el-icon-user" size="medium" v-model="admin.account"></el-input>
        </el-form-item>

        <el-form-item prop="password" style="margin-top: 15px">
          <el-input placeholder="密码" show-password prefix-icon="el-icon-lock" size="medium" v-model="admin.password"></el-input>
        </el-form-item>

        <el-radio v-model="identity" label="学生" style="color: black">学生登录</el-radio>
        <el-radio v-model="identity" label="管理员" style="color: black">管理员登录</el-radio>

        <el-form-item style="margin-top: 20px">
          <el-button style="width: 100%" size="medium" type="primary" @click="login" >
            登录
          </el-button>
        </el-form-item>

      </el-form>

    </div>

  </div>

</template>

<style>
.background-container {
  background-image: url('@/assets/login/bg.jpg');
  /* 其他样式属性 */
  background-size: cover;
  background-position: center;
}

.image {
  width: 1000px;
  height: 1000px;
  object-fit: cover; /* 根据需求设置图片填充方式 */
}

</style>

<script>
import request from "@/utils/request"
import global_ from '../../components/Global'//引用模块进来

export default {
  name: "LOGIN",

  data() {

    const checkAccount = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('账号不能为空'));
      }
    };

    const checkPassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('密码不能为空'));
      }
    };

    return {
      admin: {},
      student: {
        "sno": '',
        "password": ''
      },
      rules: {
        account: [
          {validator: checkAccount, trigger: 'blur'}
        ],
        password: [
          {validator: checkPassword, trigger: 'blur'}
        ],
      },
      identity: ''
    }

  },

  methods: {
    variableStatus(variable) {
      return variable ? '不为空' : '为空';
    },

    login() {
      if (this.variableStatus(this.admin.account) === '为空') {
        this.$notify.error("请输入账号")
      }
      else if (this.variableStatus(this.admin.password) === '为空') {
        this.$notify.error("请输入密码")
      }
      else {
        if (this.identity === "管理员") {
          request.post('/admin/login', this.admin).then(res => {
            // console.log(this.admin)
            if (res.code === '1') {
              global_.adminAccount = this.admin.account
              this.$notify.success("登录成功");
              this.$router.push('/homeAdmin')
            } else {
              this.$notify.error("用户名或密码错误")
            }
          })
        }
        else if (this.identity === "学生") {//学生登录
          this.student.sno = this.admin.account
          this.student.password = this.admin.password
          console.log(this.student)
          // this.$notify.success("进来了")
          request.post('/student/login', this.student).then(res => {
            console.log(this.student)
            if (res.code === '1') {
              global_.stuAccount = this.student.sno
              this.$notify.success("登录成功");
              this.$router.push('/homeStu')
            } else {
              this.$notify.error("用户名或密码错误")
            }
          })
        }
      }
    }
  }
}
</script>

<style scoped>

</style>