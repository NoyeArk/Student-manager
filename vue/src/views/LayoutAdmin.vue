<template>
  <div>
    <!--头部区域：白色-->
    <div style="height: 60px; line-height: 60px; background-color: #1971c2">
      <img src="@/assets/管理系统Logo.png" alt="" style="width: 40px; height: 40px; position: relative; top: 10px; left: 20px">
      <span style="margin-left: 30px; font-size: 20px; color: white">学生信息管理系统</span>
<!--      <el-link @click="redirectToPage" icon="el-icon-s-custom" target="blank" style="margin-left: 850px; height: 15px; color: white">个人中心</el-link>-->
<!--      <el-button style="color: white">个人中心</el-button>-->
    </div>

    <!--侧边栏主体-->
    <div style="display: flex; background-color: #a5d8ff">
      <!--侧边栏导航-->
      <div style="width: 200px; min-height: calc(100vh - 62px); overflow: hidden; margin-right: 2px">
        <el-menu :default-active="$route.path"  router class="el-menu-demo">
          <el-menu-item index="/homeAdmin" style="background-color: #a5d8ff">

            <img src="@/assets/admin/首页.png" alt="" style="width: 30px; height: 30px; margin-left: 25px">
            <span style="color: black; margin-left: 10px">首页</span>

          </el-menu-item>

          <el-submenu index="student" style="background-color: #a5d8ff">
            <!--            这个是左侧菜单栏的第二项内容-->
            <template slot="title">

              <!--              子菜单标题-->
              <img src="@/assets/admin/学生管理.png" alt="" style="width: 30px; height: 30px; margin-left: 25px">
              <span style="margin-left: 10px">学生管理</span>

            </template>

            <el-menu-item index="/studentList" style="background-color: #a5d8ff">
              <img src="@/assets/admin/学生列表.png" alt="" style="width: 30px; height: 30px; margin-left: 12px">
              <span style="margin-left: 12px">学生列表</span>
            </el-menu-item>

            <el-menu-item index="/addStu" style="background-color: #a5d8ff">
              <img src="@/assets/admin/添加学生.png" alt="" style="width: 30px; height: 30px; margin-left: 12px">
              <span style="margin-left: 12px">添加学生</span>
            </el-menu-item>

          </el-submenu>

          <el-menu-item index="/accountInfo" style="background-color: #a5d8ff">

            <img src="@/assets/admin/accountInfo.png" alt="" style="width: 30px; height: 30px; margin-left: 25px">
            <span style="color: black; margin-left: 10px">账号信息</span>

          </el-menu-item>

<!--          <el-submenu index="admin" style="background-color: #a5d8ff">-->
<!--            &lt;!&ndash;            这个是左侧菜单栏的第二项内容&ndash;&gt;-->
<!--            <template slot="title">-->

<!--              <i class="el-icon-user"></i>-->
<!--              &lt;!&ndash;              子菜单标题&ndash;&gt;-->
<!--              <span>管理员管理</span>-->

<!--            </template>-->

<!--            <el-menu-item index="/adminList" style="background-color: #a5d8ff">管理员列表</el-menu-item>-->
<!--            <el-menu-item index="/addAdmin" style="background-color: #a5d8ff">添加管理员</el-menu-item>-->

<!--          </el-submenu>-->

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

function delayFunction() {
  console.log("延时函数已执行");
}

// import request from "@/utils/request";
import global_ from '@/components/Global'

export default {
  name: "LayoutAdmin",
  methods: {
    redirectToPage() {
      const account = global_.adminAccount
      // this.$notify.success("进来了")
      console.log(account)
      // 存储全局变量的值到 Cookie
      // document.cookie = `myVariable=${global_}; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/`;
      // localStorage.setItem('myVariable', JSON.stringify(global_.adminAccount));

      window.location.href = '/accountInfo';
      // setTimeout(delayFunction, 10000)
    }
  }
}

</script>

<style scoped>

</style>