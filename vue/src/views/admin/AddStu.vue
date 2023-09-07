<template>
  <div style="margin-left: 20px">
    <h2 style="margin-left: 50px; margin-top: 50px">
      <span style="font-size: 25px">添加学生</span>
    </h2>

    <el-form :inline="true" :model="form" :rules="rules" style="width: 80%; margin-left: 140px; margin-top: 50px;" label-width="100px">

      <el-form-item label="学号" prop="sno">
        <el-input v-model="form.sno" placeholder="请输入学号"></el-input>
      </el-form-item>

      <el-form-item label="性别">
        <el-radio v-model="form.sex" label="男">男</el-radio>
        <el-radio v-model="form.sex" label="女">女</el-radio>
      </el-form-item>

      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.name" placeholder="请输入姓名"></el-input>
      </el-form-item>

      <el-form-item label="年龄" prop="age">
        <el-input v-model="form.age" placeholder="请输入年龄"></el-input>
      </el-form-item>

      <el-form-item label="专业">
        <el-input v-model="form.dept" placeholder="请输入专业"></el-input>
      </el-form-item>

      <el-form-item label="学院">
        <el-input v-model="form.acad" placeholder="请输入学院"></el-input>
      </el-form-item>

      <el-form-item label="高等数学">
        <el-input v-model="form.math" placeholder="请输入高数成绩"></el-input>
      </el-form-item>

      <el-form-item label="大学英语">
        <el-input v-model="form.english" placeholder="请输入英语成绩"></el-input>
      </el-form-item>

      <el-form-item label="大学物理">
        <el-input v-model="form.physics" placeholder="请输入物理成绩"></el-input>
      </el-form-item>

    </el-form>

    <div style="margin-left: 400px; margin-top: 30px">

      <el-button type="primary" @click="save" size="medium">提交</el-button>
      <el-button type="warning" @click="$router.push('/studentList')" size="medium">返回</el-button>

    </div>

  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "AddStu",
  data() {

    const checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      }
      if (!/^[0-9]+$/.test(value)) {
        callback(new Error('请输入数字值'));
      }
      if (parseInt(value) > 25 || parseInt(value) <= 18) {
        callback(new Error('请输入18~25岁之间合理年龄'));
      }
    };

    const checkSno = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('学号不能为空'));
      }
      if (!/^202\d{6}$/.test(value)) {
        callback(new Error('请输入合法的学号'));
      }
    }

    return {
      form: {sex:"男"},
      rules: {
        // name: [
        //   { required: true, message: '请输入学生姓名', trigger: 'blur'},
        // ],

        age: [
          {validator: checkAge, trigger: 'blur'}
        ],

        sno: [
          {validator: checkSno, trigger: 'blur'}
        ]
      }
    }

  },
  methods: {
    variableStatus(variable) {
      return variable ? '不为空' : '为空';
    },
    save() {

      if (this.variableStatus(this.form.sno) === '为空') {
        this.$notify.error("请输入学号")
      }
      else if (this.variableStatus(this.form.name) === '为空') {
        this.$notify.error("请输入姓名")
      }
      else if (this.variableStatus(this.form.age) === '为空') {
        this.$notify.error("请输入年龄")
      }
      else {
        request.post('/student/save', this.form).then(res => {
          console.log(this.form)
          if(res.code === '1') {
            this.$notify.success('新增成功')
            // this.$refs['ruleForm'].resetField();
            this.form = {}
          }
          else {
            this.$notify.success(res.msg)
          }
        })
      }
    }
  }
}
</script>

<style scoped>

</style>