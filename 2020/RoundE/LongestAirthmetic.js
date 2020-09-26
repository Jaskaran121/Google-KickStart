const calculate = (arrLength,arr) => {
    let max = 0;
    let index = 0;
    while(index !== arrLength-1){
        const diff = parseInt(arr[index+1],10) - parseInt(arr[index],10);
        let setLength = 0;
        while(index !== arrLength-1){
            const temp = parseInt(arr[index+1],10) - parseInt(arr[index],10);
            if(temp!==diff)
                break;
            setLength++;
            index++;
        }
        if(setLength>max)
            max = setLength;
    }
    return max+1;
}

const fs = require('fs');
const input = fs.readFileSync(0, 'utf8').trim().split('\n');

let currentline = 0;
function readline(){
    return input[currentline++];
}

let T = readline();

for(let i = 1; i <= T; i++){
    const arrLength = readline();
    const array = readline().split(' ');
    console.log(`Case #${i}: ${calculate(arrLength,array)}`);
}