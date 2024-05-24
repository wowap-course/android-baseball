//
//  OpponentBall.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

class OpponentBall : Ball{
    
    private(set) var numbers : [Int]
    
    init(numberGenerator : NumberGenerator){
        self.numbers = numberGenerator.getNumbers()
    }
    
}
