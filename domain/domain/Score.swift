//
//  Score.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/21/24.
//

import Foundation

struct Score : Equatable{
    let strike : Int
    let ball : Int
    
    init(ball: Int, strike: Int) {
        self.strike = strike
        self.ball = ball
    }
}
