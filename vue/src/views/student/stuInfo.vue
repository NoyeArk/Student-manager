<template>
  <div>
    <div style="margin-left: 120px; margin-top: 40px">
      <span style="font-size: 20px; font-weight: bold">账号信息</span>
    </div>

    <el-descriptions style="width: 300px; margin-left: 300px; margin-right: 120px; margin-top: 15px;" :column="1" :size="'medium'" border>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-user"></i>
          姓名
        </template>
        {{form.name}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          学号/账号
        </template>
        {{form.sno}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 100px">
        <template slot="label">
          <i class="el-icon-key"></i>
          密码
        </template>
        {{form.password}}
      </el-descriptions-item>

      <el-descriptions-item label-style="width: 80px">
        <template slot="label">
          <i class="el-icon-magic-stick"></i>
          年龄
        </template>
        {{form.age}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-bangzhu"></i>
          性别
        </template>
        {{form.sex}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-thumb"></i>
          专业
        </template>
        {{form.dept}}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-location-outline"></i>
          学院
        </template>
        {{form.acad}}
      </el-descriptions-item>

    </el-descriptions>

    <el-button type="primary" style="margin-left: 400px; margin-top: 20px" @click="jump(form.sno)">修改信息</el-button>

<!--    <el-popconfirm-->
<!--        title="确定重置密码为123吗？"-->
<!--        @confirm="reset">-->
<!--      <el-button type="danger" slot="reference" style="margin-left: 15px; margin-right: 400px">重置密码</el-button>-->
<!--    </el-popconfirm>-->

  </div>

</template>

<script>
import global_ from "@/components/Global";
import request from "@/utils/request";

export default {
  name: "stuInfo",
  data() {
    return {
      form: {}
    }
  },
  created() {
    const account = global_.stuAccount
    request.get('/student/list').then(res => {
      if (res.code === '1') {
        for (let i = 0; i < res.data.length; i++) {
          if (res.data[i].sno === account) {
            this.form = res.data[i]
            break
          }
        }
      }
    })
  },

  methods: {
    jump(sno) {
      this.$router.push('/editSelf?sno=' + sno)
    },
  }
}
</script>

<style scoped>

</style>