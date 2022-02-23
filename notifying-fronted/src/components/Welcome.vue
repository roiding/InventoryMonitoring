<template>
  <el-row :gutter="12" justify="center">
    <el-form
      :model="form"
      label-width="120px"
      status-icon
      :rules="commitRules"
      ref="submitForm"
    >
      <el-form-item label="订阅类型" prop="subscribeType">
        <el-select v-model="form.subscribeType">
          <el-option
            v-for="item in subscribeTypeList"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            :disabled="item.disabled"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="form.address"></el-input>
      </el-form-item>
      <el-form-item label="订阅平台" prop="platform">
        <el-select v-model="form.platform">
          <el-option
            v-for="item in platformList"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            :disabled="item.disabled"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="订阅商品" prop="itemId">
        <el-select v-model="form.itemId">
          <el-option
            v-for="item in itemIdList"
            :key="item.value"
            :label="item.label"
            :value="item.value"
            :disabled="item.disabled"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </el-row>
</template>

<script lang="ts">
import { defineComponent, reactive, toRefs, ref } from "vue";
import { ADD_NEW_SUBSCRIBE } from "../http/api";
export default defineComponent({
  name: "Welcome",
  setup(props, context) {
    const submitForm = ref(null);
    const checkEmail = (rule: any, value: any, callback: any) => {
      let mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
      if (mailReg.test(value)) {
        callback();
      } else {
        callback(new Error("请输入正确的邮箱格式"));
      }
    };
    const data = reactive({
      form: {
        subscribeType: "",
        address: "",
        platform: "",
        itemId: undefined,
      },
      subscribeTypeList: [
        {
          label: "邮箱",
          value: "email",
          disabled: false,
        },
        {
          label: "Server酱",
          value: "ServerChan",
          disabled: true,
        },
        {
          label: "更多逐渐完善",
          value: "more",
          disabled: true,
        },
      ],
      platformList: [
        {
          label: "伊利爱儿",
          value: "yili-babycare",
          disabled: false,
        },
        {
          label: "淘宝",
          value: "taobao",
          disabled: true,
        },
        {
          label: "更多逐渐完善",
          value: "more",
          disabled: true,
        },
      ],
      itemIdList: [
        {
          label: "伊利-冰墩墩钥匙扣(49元)",
          value: 1,
          disabled: false,
        },
        {
          label: "伊利-冰墩墩抱枕(68元)",
          value: 2,
          disabled: false,
        },
        {
          label: "更多逐渐完善",
          value: 0,
          disabled: true,
        },
      ],
      commitRules: {
        subscribeType: [
          {
            required: true,
            message: "请选择订阅类型",
            trigger: "change",
          },
        ],
        address: [
          {
            required: true,
            message: "地址不能为空",
            trigger: "change",
          },
          {
            validator: checkEmail,
            trigger: "change",
          },
        ],
        platform: [
          {
            required: true,
            message: "请选择订阅平台",
            trigger: "change",
          },
        ],
        itemId: [
          {
            required: true,
            message: "请选择订阅商品",
            trigger: "blur",
          },
        ],
      },
    });
    const onSubmit = () => {
      submitForm.value
        .validate()
        .then(() => {
          ADD_NEW_SUBSCRIBE(data.form.subscribeType,data.form.address,data.form.platform,data.form.itemId).then(response=>{
            ElMessage.success(response.data.data)
          })
        })
        .catch((error) => {
          ElMessage.error("请检查表单输入");
        });
    };

    return {
      submitForm,
      ...toRefs(data),
      onSubmit,
    };
  },
});
</script>

<style scoped>
</style>
