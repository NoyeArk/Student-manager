<template>
  <div>
    <!--头部区域：白色-->
    <div style="height: 60px; line-height: 60px; background-color: #1971c2">
<!--      <router-link :to="http:localhost:8080/testInfo">数据详情</router-link>-->
      <img src="@/assets/管理系统Logo.png" alt="" style="width: 40px; height: 40px; position: relative; top: 10px; left: 20px">
      <span style="margin-left: 30px; font-size: 20px; color: white">学生信息管理系统</span>
<!--      <el-link @click="redirectToPage" icon="el-icon-s-custom" target="blank" style="margin-left: 850px; height: 15px; color: white">个人中心</el-link>-->
<!--      <el-button style="color: white">个人中心</el-button>-->
    </div>

    <!--侧边栏主体-->
    <div style="display: flex; background-color: #a5d8ff">
      <!--侧边栏导航-->
      <div style="width: 200px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px">
        <el-menu :default-active="$route.path" :router="true" router class="el-menu-demo">

          <el-menu-item index="homeStu" style="background-color: #a5d8ff">
            <img src="@/assets/student/我的成绩.png" alt="" style="width: 30px; height: 30px; margin-left: 25px">
            <span style="color: black; margin-left: 10px">我的成绩</span>
          </el-menu-item>

          <el-menu-item index="stuInfo" style="background-color: #a5d8ff">
            <img src="@/assets/student/个人中心.png" alt="" style="width: 30px; height: 30px; margin-left: 25px">
            <span style="color: black; margin-left: 10px">个人中心</span>
          </el-menu-item>

        </el-menu>
      </div>

      <!--主体数据-->
      <div style="flex: 1; background-color: #e7f5ff" >


        <router-view/>
      </div>
    </div>

  </div>
</template>

<script>
import global_ from "@/components/Global";

export default {
  name: "LayoutStu",

  methods: {
    redirectToPage() {
      const account = global_.stuAccount
      console.log(account)

      window.location.href = '/stuInfo';
      // setTimeout(delayFunction, 10000)
    }
  }
}
</script>

<style scoped>

</style>