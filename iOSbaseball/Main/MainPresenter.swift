//
//  MainPresenter.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/22/24.
//

import domain

class MainPresenter : MainViewPresenter{
    
    let view : MainView!
    var lifeCount: LifeCount!
    var opponentBall : OpponentBall!
    let referee = Referee()
    
    init(view: MainView, initLifeCount:Int) throws {
        self.view = view
        
        self.lifeCount = try LifeCount(lifes: initLifeCount)
        view.showLife(lifeCount: lifeCount.lifes)
        
        self.opponentBall = OpponentBall(numberGenerator: RandomNumberGenerator())
    }
    
    func game(userNumber: String) {
        do {
            let userNumbers = try UserBall(numbers: (userNumber.compactMap { Int(String($0)) })).numbers
            
            let resultScore = referee.getGameScore(baseNumbers: userNumbers, targetNumbers: opponentBall.numbers)
            
            if resultScore.strike == 3 { view.showSuccess(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!, lifeCount: lifeCount.lifes)}
            view.showResult(ball: resultScore.ball, strike: resultScore.strike)
            
            if lifeCount.decrease() { view.showLife(lifeCount: lifeCount.lifes) }
            else { endGame() }
            
        } catch {
            view.showInputError(inputText: userNumber)
        }

    }
    
    func endGame(){
        view.showFail(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!)
    }
    
    
    func resultGamePrint(){
        view.showSuccess(opponentNumber: Int(opponentBall.numbers.map(String.init).joined())!, lifeCount: lifeCount.lifes)
    }
    
}
