
//1번
const arr1_1 = [2, 1, 3, 1, 2, 1];
const arr1_2 = [3, 3, 3, 3, 3, 3];
const arr1_3 = [1, 2, 3];

// console.log(solution1(arr1_1));
// console.log(solution1(arr1_2));
// console.log(solution1(arr1_3));

function solution1(arr) {
    let max = 0;
    let cnt = [0, 0, 0];

    for(let i = 0; i < arr.length; i++) {
        const num = arr[i];
        cnt[num - 1] = cnt[num - 1] + 1;
        max = Math.max(max, cnt[num - 1]);
    }

    return cnt.map((i, idx) => {
        return max - cnt[idx];
    });
}

//2번
const arr2_1 = ["08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"];
const arr2_2 = ["01:00", "08:00", "15:00", "15:04", "23:00", "23:59"];

// console.log(solution2(arr2_1));
// console.log(solution2(arr2_2));
function solution2(arr){
    let totMin = 0;

    for(let i = 0; i < arr.length; i+=2) {
        const start = arr[i].split(":"); // 시작시간
        const end = arr[i+1].split(":"); // 종료시간
        const startMin = Number(start[0]) * 60 + Number(start[1]); // 시작시간 분단위
        const endMin = Number(end[0]) * 60 + Number(end[1]); //종료시간 분단위
        const during = endMin - startMin; // 공부시간 분단위

        if(during > 105)totMin += 105; //1시간 45분이 넘어갈 경우
        else if(during >= 5) totMin += during; //5분이상 공부한 경우
    }

    let totHour = Math.floor(totMin / 60)
    totMin -= 60 * totHour;

    return (totHour >= 10 ? totHour : "0" + totHour) + ":" + (totMin >= 10 ? totMin : "0" + totMin);
}

//3번
const ings1 = ["r 10", "a 23", "t 124", "k 9"];
const menu1 = ["PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"];
const sell1 = ["BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"];

const ings2 = ["x 25", "y 20", "z 1000"];
const menu2 = ["AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"];
const sell2 = ["BBBB 3", "TTT 2"];

// console.log(solution3(ings1, menu1, sell1));
// console.log(solution3(ings2, menu2, sell2));

function solution3(ings, menu, sell) {
    let answer = 0;
    let ingsObj = {}; // 원가 객체
    let menuObj = {}; // 메뉴별 수익 객체

    for(let i = 0; i < ings.length; i++) {
        const ing = ings[i].split(" ");
        ingsObj[ing[0]] = Number(ing[1]);
    }

    for(let i = 0; i < menu.length; i++) {
        const mn = menu[i].split(" ");
        let sum = 0;
        for(let j = 0; j < mn[1].length; j++) {
            sum += ingsObj[mn[1][j]];
        }
        menuObj[mn[0]] = Number(mn[2]) - sum;
    }

    for(let i = 0; i < sell.length; i++) {
        const s = sell[i].split(" ");
        answer += menuObj[s[0]] * Number(s[1]);
    }

    return answer;
}

//4번
const s1 = "aaabbaaa";
const s2 = "wowwow";
// console.log(solution4(s1));
// console.log(solution4(s2));

function solution4(s) {
    let answer = [];
    const arr = s.split("");
    while(arr[0] == arr[arr.length - 1]) {
        let c = arr.shift();
        arr.push(c);
    }

    let curr = arr[0];
    let cnt = 0;
    for(let i = 0; i < arr.length; i++) {
        if(curr == arr[i]) cnt++;
        else{
            answer.push(cnt);
            cnt = 1;
            curr = arr[i];
        }
        if(i == arr.length - 1) answer.push(cnt); //마지막일 경우
    }

    answer.sort();
    return answer;
}

//5번
const rows1 = 3;
const columns1 = 4;

const rows2 = 3;
const columns2 = 3;

//console.log(solution5(rows1, columns1));
//console.log(solution5(rows2, columns2));

function solution5(rows, columns) {
    const arr = Array.from(Array(rows), () => Array.from(Array(columns), () => Array(2).fill(0)));
    const answer = Array.from(Array(rows), () => Array(columns).fill(0));

    let zeroCnt = rows * columns; // 0의 개수
    DFS(0, 0, 0);
    function DFS(r, c, num){
        if(zeroCnt == 0) return;
        else{
            num++;
            if(arr[r][c][num % 2] == 1){ return;}
            if(answer[r][c] == 0) zeroCnt--;

            answer[r][c] = num;
            arr[r][c][num % 2] = 1;
            if(num % 2 == 0){
                DFS(r == (rows - 1) ? 0 : r+1, c, num);
            }
            else {
                DFS(r,  (c == (columns - 1) ? 0 : c+1) , num);
            }
        }
    }

    return answer;
}
//6번
const time = 3.5;
const plans = [["홍콩", "11PM", "9AM"], ["엘에이", "3PM", "2PM"]];

//console.log(solution6(time, plans));
function solution6(time, plans) {
    let answer = "";
    for(const plan of plans) {
        let start = Number(plan[1].length > 3 ? plan[1].substring(0,2) : plan[1].substring(0,1));
        let end = Number(plan[2].length > 3 ? plan[2].substring(0,2) : plan[2].substring(0,1));
        if(plan[1].includes("PM")) start += 12;
        if(plan[2].includes("PM")) end += 12;
        if(18 - start > 0) time -= 18 - start;
        if(end - 13 > 0) time -= end - 13;
        if(time >= 0) answer = plan[0];
    }
    return answer;
}



//7번
const grid1 = ["1","234","56789"];
const grid2 = ["A","MAN","DRINK","WATER11"];

console.log(solution7(grid1, true));
console.log(solution7(grid2, false));

function solution7(grid, clockwise) {
    let answer = [];
    let idx = grid.length - 1;
    while(answer.length < grid.length) {
        let str = "";
        if(clockwise) {
            for (let i = grid.length - 1; i >= idx; i--) {
                let gridStr = grid[i];
                if (i == idx) {
                    str += gridStr[0];
                    grid[i] = gridStr.substring(1, gridStr.length);
                } else {
                    str += gridStr[1] + gridStr[0];
                    grid[i] = gridStr.substring(2, gridStr.length);
                }
            }
        }else{
            for(let i = idx; i < grid.length; i++){
                let gridStr = grid[i];
                if( i == idx) {
                    str += gridStr[gridStr.length - 1];
                    grid[i] = gridStr.substring(0, gridStr.length - 1);
                }else{
                    str += gridStr[gridStr.length - 1] + gridStr[gridStr.length - 2];
                    grid[i] = gridStr.substring(0, gridStr.length - 2);
                }
            }
        }
        idx--;
        answer.push(str);
    }
    return answer;
}