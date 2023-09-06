<template>
  <div style="margin-left: 10px">
    <h2 style="margin-bottom: 30px; margin-left: 80px">修改用户信息</h2>

    <el-form :inline="true" :model="form" style="width: 80%; margin-left: 200px" label-width="100px">

      <div style="margin-left: 15px; margin-top: 50px; margin-bottom: 20px">
        <span style="font-size: 18px">基本信息</span>
      </div>

      <el-form-item label="用户名">
        <el-input v-model="form.username" placeholder="请输入姓名"></el-input>
      </el-form-item>

      <el-form-item label="账号">
        <el-input v-model="form.account" placeholder="请输入账号"></el-input>
      </el-form-item>

      <el-form-item label="电话">
        <el-input v-model="form.phone" placeholder="请输入电话"></el-input>
      </el-form-item>

      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>

      <el-form-item label="邮箱">
        <el-input v-model="form.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>

    </el-form>

    <div style="text-align: center; margin-top: 30px">

      <el-button type="primary" @click="save" size="medium">提交</el-button>
      <el-button type="danger" @click="$router.push('accountInfo')" size="medium">返回</el-button>
    </div>

  </div>
</template>

<script>
import request from "@/utils/request";
import global_ from "@/components/Global";

export default {
  name: "editAdmin",
  data() {
    return {
      form: {}
    }
  },
  created() {
    const queryAccount = this.$route.query.account;
    // console.log(queryAccount)
    request.get('/admin/list').then(res => {
      if (res.code === '1') {
        for (let i = 0; i < res.data.length; i++) {
          if (res.data[i].account === queryAccount) {
            this.form = res.data[i]
            break
          }
        }
        console.log(this.form)
      }
    })

  },

  methods: {
    save() {
      request.put('/admin/update', this.form).then(res => {
        if(res.code === '1') {
          this.$notify.success('更新成功')
          // this.form = {}
          this.$router.push('/accountInfo')
        }
        else {
          this.$notify.success(res.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>