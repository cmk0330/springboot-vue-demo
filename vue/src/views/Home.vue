<template>
  <div style="padding: 10px">

    <div style="margin: 10px">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="date" label="Date" width="180" sortable/>
      <el-table-column prop="name" label="Name" width="180"/>
      <el-table-column prop="address" label="Address"/>
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default>
          <el-button type="text" size="small" @click="handleClick"
          >Detail
          </el-button
          >
          <el-button type="text" size="small">Edit</el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="demo-pagination-block">
      <el-pagination
          v-model:currentPage="currentPage1"
          :page-size="100"
          layout="total, prev, pager, next"
          :total="1000"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">

      </el-pagination>
    </div>
    <div>
      <el-pagination
          v-model:currentPage="currentPage2"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="10"
          layout="sizes, prev, pager, next"
          :total="10"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">
      </el-pagination>
    </div>

    <el-dialog v-model="dialogVisible" title="提示" width="30%">
      <el-form label-width="120px">
        <el-form-item label="用户名">
          <el-input v-model="form.userName"/>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password"/>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="form.nickName"/>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio v-model="form.sex" label="男">男</el-radio>
          <el-radio v-model="form.sex" label="女">女</el-radio>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age"/>
        </el-form-item>
        <el-form-item label="地址">
          <el-input type="textarea" v-model="form.address"/>
        </el-form-item>

      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">保存</el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'Home',
  components: {},
  methods: {
    add() {
      this.dialogVisible = true
      this.form = {}
    },
    save() {
      console.log("11111")
      request.post("/user", this.form).then(res => {
        console.log(res)
      })
    },
    load() {
      request.get("/user", {
        pageNum: this.currentPage,
        pageSize: this.pageSize,
        search: this.search
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
      })
    }
  },
  data() {
    return {
      dialogVisible: false,
      form: {},
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  },
  created() {
    this.load()
  }
}
</script>
