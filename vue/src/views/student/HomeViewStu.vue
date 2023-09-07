<template v-slot="scope">

  <div>
    <div style="margin-left: 120px; margin-top: 50px">
      <span style="font-size: 20px; font-weight: bold">我的成绩</span>
    </div>

    <el-descriptions style="margin-left: 150px; margin-right: 120px; margin-top: 50px;" :column="3" :size="'medium'" border>

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



  </div>

</template>

<style>

.custom-title {
  font-size: 16px; /* 标题字体大小 */
}

</style>

<script>

import request from "@/utils/request";
import global_ from "@/components/Global"

export default {
  name: 'HomeViewStu',

  data() {
    return {
      form: {},
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
        console.log(this.form)
      }
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