<template>

  <div class="home">

    <div style="margin-left: 40px; margin-top: 25px">
      <span style="color: black; font-weight: bold; font-size: 35px">欢迎登录学生信息管理系统</span>


<!--      <el-calendar :range="['2023-07-03', '2023-07-30']">-->
<!--      </el-calendar>-->

    </div>
  </div>
</template>

<style>

.el-calendar-day{
  width:  500px;
  height: 400px;
}

</style>

<script>
export default {
  data() {
    return {
      value: new Date()
    }
  }
}
</script>
