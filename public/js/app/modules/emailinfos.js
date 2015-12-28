/**
 */

define(function(require) {
    require('../common/common');  // 公共模块
    require('../../thirdParty/dialog');  // 弹窗插件
    require('../../thirdParty/underscore');
    
    var ajax = require('../util/ajax');
    var dd = require('../util/dialog');
    var template = require('../common/module/template_native');

    var User = {
        init: function() {
            //$.get("/User/list");
            this.createEmail($('[role="create"]'));
            this.deleteEmail($('[role="delete"]'));
            this.editEmail($('[role="edit"]'));
        },

        /**
         * 添加邮箱信息
         */
        createEmail: function(obj) {
            var self = this;

            obj.click(function() {
                var $this = $(this),
                    $wrap = $this.closest('.folded-panel'),
                    $hiddenInputs = $wrap.find('input:hidden');

                var createDialog = dialog({
                    id: 'createDialog',
                    title: '添加',
                    content: document.getElementById('createDialogTmpl').innerHTML,
                    button: [
                        {
                            value: '保存',
                            callback: function () {
                                var dia = this,
                                    $form = this.__popup.find('form');

                                ajax.post($form.attr('action'), $form.serialize(), function(result){
                                    if(result.success){
                                        dia.close();
                                        dd.alert('添加成功！', function(){
                                            window.location.reload(false);
                                       });
                                    }else{
                                        dd.alert(result.error);
                                    }
                                });
                                return false;
                            },
                            autofocus: true
                        }
                    ],
                    cancelValue: '取消',
                    cancel: function() {

                    },
                    onshow: function() {
                        
                    }
                }).showModal();
            });
        },
        
        

        /**
         * 删除
         */
        deleteEmail: function(obj) {
            obj.click(function() {
                var $this = $(this),
                    $wrap = $this.closest('tr'),
                	$emailId = $wrap.find('.id'),
                	emailId = $emailId.val();
                
                var deleteLevelDialog = dialog({
                    id: 'deleteDialog',
                    title: '删除邮箱信息',
                    content: document.getElementById('deleteDialogTmpl').innerHTML,
                    button: [
                        {
                        	value: '确定',
                            callback: function () {
                                var dia = this,
                                $form = this.__popup.find('form');
                                
                                ajax.post($form.attr('action'), $form.serialize(), function(result){
                                    if(result.success){
                                        dia.close();
                                        dd.alert('删除成功！', function(){
                                            window.location.reload(false);
                                       });
                                    }else{
                                        dd.alert(result.error);
                                    }
                                });
                                return false;
                            },
                            autofocus: true
                        }
                    ],
                    cancelValue: '取消',
                    cancel: function() {

                    },
                    onshow:function() {
                    	$("#emailId").val(emailId);
                    }
                }).showModal();
            });
        },

        /**
         * 编辑邮箱信息
         */
        editEmail: function(obj) {
            obj.click(function() {
                var $this = $(this),
                    $wrap = $this.closest('tr'),
                    $id = $wrap.find('.id'),
                    $name = $wrap.find('.name'),
                    $address = $wrap.find('.address'),
                    id = $id.val(),
                	name = $name.val(),
                	address = $address.val();
                
                var editLevelDialog = dialog({
                    id: 'editDialog',
                    title: '编辑等级等级提成',
                    content: document.getElementById('editDialogTmpl').innerHTML,
                    button: [
                        {
                        	value: '确定',
                            callback: function () {
                                var dia = this,
                                $form = this.__popup.find('form');
                                
                                ajax.post($form.attr('action'), $form.serialize(), function(result){
                                    if(result.success){
                                        dia.close();
                                        dd.alert('修改邮箱信息成功！', function(){
                                            window.location.reload(false);
                                       });
                                    }else{
                                        dd.alert(result.error);
                                    }
                                });
                                return false;
                            },
                            autofocus: true
                        }
                    ],
                    cancelValue: '取消',
                    cancel: function() {

                    },
                    onshow:function() {
                    	$("#emailId").val(id);
                    	$("#emailName").val(name);
                    	$("#emailAddress").val(address);
                    }
                }).showModal();
            });
        }
        
    }

    User.init();
});
