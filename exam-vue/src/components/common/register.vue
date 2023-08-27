<!-- 注册 -->
<template>
    <section class="add">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="姓名">
                <el-input v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="学院">
                <el-input v-model="form.institute"></el-input>
            </el-form-item>
            <el-form-item label="电话号码">
                <el-input v-model="form.tel"></el-input>
            </el-form-item>
            <el-form-item label="email">
                <el-input v-model="form.email"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.pwd"></el-input>
            </el-form-item>
            <el-form-item label="身份证号">
                <el-input v-model="form.cardId"></el-input>
            </el-form-item>
            <el-form-item label="您的身份">
                <el-radio label="1" v-model="form.role" name="selectRole">老师</el-radio>
                <el-radio label="2" v-model="form.role" name="selectRole">学生</el-radio>
            </el-form-item>
            <el-form-item label="年级" v-show="form.role == 2">
                <el-input v-model="form.grade"></el-input>
            </el-form-item>
            <el-form-item label="专业" v-show="form.role == 2">
                <el-input v-model="form.major"></el-input>
            </el-form-item>
            <el-form-item label="班级" v-show="form.role == 2">
                <el-input v-model="form.clazz"></el-input>
            </el-form-item>
            <el-form-item label="职称" v-show="form.role == 1">
                <el-input v-model="form.type"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-radio label="男" v-model="form.sex" name="selectSex">男</el-radio>
                <el-radio label="女" v-model="form.sex" name="selectSex">女</el-radio>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit()">立即创建</el-button>
                <el-button type="text" @click="cancel()">取消</el-button>
            </el-form-item>
        </el-form>
    </section>
</template>
  
<script>
export default {
    data() {
        return {
            form: { //表单数据初始化
                userName: null,
                grade: null,
                major: null,
                clazz: null,
                institute: null,
                tel: null,
                email: null,
                pwd: null,
                cardId: null,
                sex: null,
                role: "2"
            }
        };
    },

    methods: {
        onSubmit() { //数据提交
            this.$axios({
                url: '/api/register',
                method: 'post',
                data: {
                    ...this.form
                }
            }).then(res => {
                if (res.data.code == 0) {
                    alert(res.data.message)
                    this.$router.push({ path: '/' })
                } else {
                    alert(res.data.message)
                }
            }).catch(error => {
                console.log(error);
            })
        },
        cancel() { //取消按钮
            this.form = {}
            this.$router.push({ path: '/' })
        },

    }
};
</script>
<style lang="less" scoped>
.add {
    padding: 30px 40px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}

.el-form {
    width: 400px;
    padding: 20px 30px;
    background-color: #78dd5fd1;
}
</style>
  
  