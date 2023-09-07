<template>
  <div style="margin-left: 10px">
    <h2 style="margin-bottom: 30px; margin-left: 80px">修改用户信息</h2>

    <el-form :inline="true" :model="form" style="width: 80%; margin-left: 200px" label-width="100px">

      <div style="margin-left: 15px; margin-top: 50px; margin-bottom: 20px">
        <span style="font-size: 18px">基本信息</span>
      </div>

      <el-form-item label="姓名">
        <el-input v-model="form.name" placeholder="请输入姓名" disabled @click.native="hFocus"></el-input>
      </el-form-item>

      <el-form-item label="学号/账号">
        <el-input v-model="form.sno" placeholder="请输入账号" disabled @click.native="hFocus"></el-input>
      </el-form-item>

      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>

      <el-form-item label="年龄">
        <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
      </el-form-item>

      <el-form-item label="性别">
        <el-input v-model="form.sex" placeholder="请输入性别"></el-input>
      </el-form-item>

      <el-form-item label="专业">
        <el-input v-model="form.dept" disabled @click.native="hFocus"></el-input>
      </el-form-item>

      <el-form-item label="学院">
        <el-input v-model="form.acad" disabled @click.native="hFocus"></el-input>
      </el-form-item>

    </el-form>

    <div style="text-align: center; margin-top: 30px">

      <el-button type="primary" @click="save" size="medium">提交</el-button>
      <el-button type="danger" @click="$router.push('/stuInfo')" size="medium">返回</el-button>
    </div>

  </div>
</template>

<script>
import request from "@/utils/request";
import global_ from "@/components/Global";

export default {
  name: "editSelf",
  data() {
    return {
      form: {}
    }
  },
  created() {
    const queryAccount = this.$route.query.sno;
    // console.log(queryAccount)
    request.get('/student/list').then(res => {
      if (res.code === '1') {
        for (let i = 0; i < res.data.length; i++) {
          if (res.data[i].sno === queryAccount) {
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
      request.put('/student/update', this.form).then(res => {
        if(res.code === '1') {
          this.$notify.success('更新成功')
          // this.form = {}
          this.$router.push('/stuInfo')
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