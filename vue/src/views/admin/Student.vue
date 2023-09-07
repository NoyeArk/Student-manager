<template>

  <div>
    <!--    搜索表单-->
    <div style="margin-bottom: 10px; margin-left: 5px">

      <el-input style="width: 170px; margin-left: 5px; margin-top: 15px" placeholder="请输入学号" v-model="params.sno">

      </el-input>
      <el-input style="width: 170px; margin-left: 10px" placeholder="请输入名称" v-model="params.name">

      </el-input>

      <el-button style="margin-left: 10px" type="primary" @click="load"><i class="el-icon-search"></i> 搜索</el-button>
      <el-button style="margin-left: 10px" type="warning" @click="reset"><i class="el-icon-refresh"></i> 重置</el-button>

    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="sno" label="学号"></el-table-column>
      <el-table-column prop="age" label="年龄"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="dept" label="专业"></el-table-column>
      <el-table-column prop="acad" label="学院"></el-table-column>

      <el-table-column label="操作">
        <template v-slot="scope">
<!--          scope.row就是当前行数据-->

          <el-button type="primary" @click="$router.push('/showStu?sno=' + scope.row.sno)">详情</el-button>

          <el-popconfirm
              title="确定删除该学生记录吗？"
              @confirm="del(scope.row.sno)"
          >
            <el-button type="danger" slot="reference" style="margin-left: 10px">删除</el-button>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>

    <!--    分页-->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>
    </div>

  </div>

</template>

<script>

import request from "@/utils/request";

export default {
  name: 'Student',

  data() {
    return {
      tableData: [],
      total: 0,
      params: {
        pageNum: 1,
        pageSize: 15,
        name: '',
        sno: '',
        sex:''
      }
    }
  },

  created() {
    this.load()
  },

  methods: {
    load() {
      // fetch('http://localhost:9090/student/list').then(res => res.json()).then(res => {
      //   console.log(res)
      //   this.tableData = res
      request.get('/student/page', {
        params: this.params
      }).then(res => {
        if (res.code === '1') {
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },

    reset() {
      this.params = {
        pageNum: 1,
        pageSize: 15,
        name: '',
        sno: '',
        sex: ''
      }
      this.load()
    },
    handleCurrentChange(pageNum) {
      //点击分页按钮触发分页
      this.params.pageNum = pageNum
      this.load()
    },
    del(sno) {
      request.delete("/student/delete/" + sno).then(res => {

        if(res.code === '1') {
          this.$notify.success('删除成功')
          this.load()
          // this.$router.push('/')
        }
        else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}

</script>

<style scoped>

</style>