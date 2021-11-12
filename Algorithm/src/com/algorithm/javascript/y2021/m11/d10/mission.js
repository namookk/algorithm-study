const data1 = "[1,2,[3,4,[5,[6]]]]";
const data2 = "[1,2,[3],4,[5,6,[7,8]],9,[10]]";
const data3 = "[1,2,[3,4],5,6]]";
const data4 = "[1,[2,3],[5,6],[7,[8,9],[1,2";

class Node{
    constructor(type, child, value) {
        this._obj = {};
        this._obj.type = type;
        this._obj.child = child;
        if(value) this._obj.value = value;
    }
    getValue() {
        return this._obj;
    }
    setChild(data) {
        this._obj.child.push(data);
    }
}

class Stack{
    constructor() {
        this._arr = [];
    }
    push(val) {
        this._arr.push(val);
    }
    poll() {
        return this._arr.pop();
    }
    peek() {
        return this._arr.length > 0 ? this._arr[this._arr.length - 1] : null;
    }
    isEmpty() {
        return this._arr.length === 0;
    }
}

class Queue{
    constructor() {
        this._arr = [];
    }
    offer(val) {
        this._arr.push(val);
    }
    poll() {
        return this._arr.shift();
    }
    peek() {
        return this._arr.length > 0 ? this._arr[0] : null;
    }
    isEmpty() {
        return this._arr.length === 0;
    }
    size() {
        return this._arr.length;
    }
}
console.log(checkParenthesis(data1));
console.log(checkParenthesis(data2));
console.log(checkParenthesis(data3));
console.log(checkParenthesis(data4));

function checkParenthesis(s) {
    let arr;
    try{
        arr = JSON.parse(s);
    }catch(e){
        return '닫는 괄호가 일치하지 않습니다.';
    }

    const queue = new Queue();
    let level = 0;
    let numCnt = 0;
    queue.offer(arr);
    while(!queue.isEmpty()) {
        const len = queue.size();
        for(let i = 0; i < len; i++) {
            const item = queue.poll();
            for(let j = 0; j < item.length; j++) {
                if(typeof item[j] == 'object') {
                    queue.offer(item[j]);
                }else{
                    numCnt++;
                }
            }
        }
        level++;
    }

    return `배열의 중첩된 깊이 수준은 ${level}이며, 총 ${numCnt}개의 원소가 포함되어 있습니다`;
}
console.log(run(data1));
function run(s){
    let arr;
    try{
        arr = JSON.parse(s);
    }catch(e){
        return '닫는 괄호가 일치하지 않습니다.';
    }
    const node = new Node("root", []);
    node.setChild(recursive(arr, new Node("array", [])));

    function recursive(item, node){
        for(let i = 0 ; i < item.length; i++) {
            if(typeof item[i] == 'object') {
                node.setChild(recursive(item[i], new Node("array", [])));
            }else{
                node.setChild(new Node("number", [], item[i]).getValue());
            }
        }
        return node.getValue();
    }

    return JSON.stringify(node.getValue());
}
//"[1,2,[3],4,[5,6,[7,8]],9,[10]]"
function run2(s) {
    const root = new Node("root", []);
    let flag = true;
    const stack = new Stack(); // 배열 스택 Stack<Node>
    const qStack = new Stack(); // 큐 스택 Stack<Queue>
    recursive(0);
    function recursive(idx) {
        let node;
        if(s[idx] == ','){
        }else if(s[idx] == '['){
            stack.push(new Node("array", []));
            qStack.push(new Queue());
        }else if(s[idx] == ']'){
            if(stack.isEmpty()){
                flag = false;
                return;
            }
            node = stack.poll();
            let q = qStack.poll();
            if(q != null){
                while(!q.isEmpty()){
                    node.setChild(q.poll().getValue());
                }
            }
            if(!qStack.isEmpty()){
                let q2 = qStack.poll();
                q2.offer(node);
                qStack.push(q2);
            }
        }else{
            let q = qStack.poll();
            q.offer(new Node("number", [], s[idx]));
            qStack.push(q);
        }
        if (idx == s.length - 1){
            if(node) root.setChild(node.getValue());
            else {flag = false;}
        }else{
            recursive(idx + 1);
        }
    }
    if(!flag) return "정상적인 배열이 아닙니다.";
    return JSON.stringify(root.getValue());
}