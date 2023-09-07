<template>
  <div style="margin-left: 10px">
    <h2 style="margin-bottom: 30px; margin-left: 80px">修改学生信息</h2>

    <el-form :inline="true" :model="form" style="width: 80%; margin-left: 200px" label-width="100px">

      <div style="margin-left: 15px; margin-top: 20px; margin-bottom: 20px">
        <span style="font-size: 18px">基本信息</span>
      </div>

      <el-form-item label="姓名">
        <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
      </el-form-item>

      <el-form-item label="性别">
        <el-input v-model="form.sex" placeholder="请输入性别"></el-input>
      </el-form-item>

      <el-form-item label="年龄">
        <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
      </el-form-item>

      <el-form-item label="专业">
        <el-input v-model="form.dept" placeholder="请输入专业"></el-input>
      </el-form-item>

      <el-form-item label="学院">
        <el-input v-model="form.acad" placeholder="请输入学院"></el-input>
      </el-form-item>

      <el-form-item label="密码">
        <el-input v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>

      <div style="margin-left: 15px; margin-top: 20px; margin-bottom: 20px">
        <span style="font-size: 18px">成绩信息</span>
      </div>

      <el-form-item label="高等数学">
        <el-input v-model="form.math" placeholder="请输入学院"></el-input>
      </el-form-item>

      <el-form-item label="大学英语">
        <el-input v-model="form.english" placeholder="请输入学院"></el-input>
      </el-form-item>

      <el-form-item label="大学物理">
        <el-input v-model="form.physics" placeholder="请输入学院"></el-input>
      </el-form-item>


    </el-form>

    <div style="text-align: center; margin-top: 30px">

      <el-button type="primary" @click="save" size="medium">提交</el-button>
      <el-button type="danger" @click="$router.push('/studentList')" size="medium">返回</el-button>
    </div>

  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "EditStu",
  data() {
    return {
      form: {}
    }
  },
  created() {
    const sno = this.$route.query.sno;
    request.get('/student/' + sno).then(res => {
      this.form = res.data
    })
  },

  methods: {
    save() {
      request.put('/student/update', this.form).then(res => {
        if(res.code === '1') {
          this.$notify.success('更新成功')
          // this.form = {}
          this.$router.push('/studentList')
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