function solution(files) {
    var answer = [];
    
    for (let f of files) {
        let fileLength = f.length;
        let head = '';
        let number = '';
        let tail = '';
        let index = 0;
        
        // head: 숫자 나오기 전까지 몽땅
        while (index < fileLength && (isNaN(f[index]) || f[index] === ' ')) {
            head += f[index];
            index++;
        }

        // number: 최대 5자리 숫자
        let count = 0;
        while (index < fileLength && !isNaN(f[index]) && f[index] !== ' ' && count < 5) {
            number += f[index];
            index++;
            count++;
        }

        // tail: 남은거 전부
        while (index < fileLength) {
            tail += f[index];
            index++;
        }

        answer.push(new File(head, number, tail));
    }

    answer.sort((a, b) => {
        if (a.upperHead !== b.upperHead) {
            return a.upperHead.localeCompare(b.upperHead);
        } else {
            return Number(a.number) - Number(b.number);
        }
    });

    return answer.map(v => v.getFilename());
}

function File(head, number, tail) {
    this.head = head;
    this.upperHead = head.toUpperCase();
    this.number = number;
    this.tail = tail;
    this.getFilename = function() {
        return this.head + this.number + this.tail;
    };
}
