<template v-slot="scope">

  <div>
    <div style="margin-left: 120px; margin-top: 40px">
      <span style="font-size: 20px; font-weight: bold">学生信息</span>
    </div>

    <el-descriptions style="margin-left: 120px; margin-right: 120px; margin-top: 15px;" :column="3" :size="'medium'" border>

      <el-descriptions-item label-style="width: 80px">
        <template slot="label">
          <i class="el-icon-user"></i>
          姓名
        </template>
        {{this.form.name}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 80px">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          学号
        </template>
        {{this.form.sno}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 80px">
        <template slot="label">
          <i class="el-icon-bangzhu"></i>
          性别
        </template>
        {{this.form.sex}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-magic-stick"></i>
          年龄
        </template>
        {{this.form.age}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-thumb"></i>
          专业
        </template>
        {{this.form.dept}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          学院
        </template>
        {{this.form.acad}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-key"></i>
          密码
        </template>
        {{this.form.password}}
      </el-descriptions-item>

    </el-descriptions>

    <div style="margin-left: 120px; margin-top: 20px">
      <span style="font-size: 20px; font-weight: bold">学生成绩</span>
    </div>

    <el-descriptions style="margin-left: 120px; margin-right: 120px; margin-top: 15px;" :column="3" :size="'medium'" border>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label" >
          <i class="el-icon-tickets"></i>
          高等数学
        </template>
        {{this.form.math}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-tickets"></i>
          大学英语
        </template>
        {{this.form.english}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-tickets"></i>
          大学物理
        </template>
        {{this.form.physics}}
      </el-descriptions-item>

    </el-descriptions>

    <el-button type="primary" style="margin-left: 420px;  margin-top: 20px" @click="jump(form.sno)" size="medium">编辑</el-button>
    <el-button type="warning" @click="$router.push('/studentList')" size="medium" style="margin-right: 400px;">返回</el-button>

  </div>

</template>

<style>

.custom-title {
  font-size: 16px; /* 标题字体大小 */
}

</style>

<script>

import request from "@/utils/request";

export default {
  name: 'ShowStu',

  data() {
    return {
      form: {}
    }
  },

  created() {
    const sno = this.$route.query.sno;
    request.get('/student/' + sno).then(res => {
      this.form = res.data
      console.log(this.form)
    })
  },

  methods: {
    jump(sno) {
      this.$router.push('/editStu?sno='+sno)
    }
  }
}

</script>

<style scoped>

</style>