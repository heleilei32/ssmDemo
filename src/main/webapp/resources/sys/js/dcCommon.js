	//选择下拉列表
    function selectOptionByIndex(index, selectName) {
        var selectFlag = getObj(selectName);
        var len = selectFlag.options.length;
        if (index >= 0 && index < len) {
            selectFlag.options[index].selected = 'selected';
        }
    }
    //选择下拉列表
    function selectOptionByValue(value, selectName) {
        var selectFlag = getObj(selectName);
        var len = selectFlag.options.length;
        for (var i = 0; i < len; i++) {
            if (value == selectFlag.options[i].value) {
                selectFlag.options[i].selected = 'selected';
                return;
            }
        }
    }
    //得到对象
    function getObj(id) {
        return document.getElementById(id);
    }
    
    //转换Boolean类型
    function conversionBoolean(bool_) {
    	if("true" == bool_){
    		return "1";
    	}
    	if("false" == bool_){
    		return "0";
    	}
        return "0";
    }
    