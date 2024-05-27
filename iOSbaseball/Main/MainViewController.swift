//
//  ViewController.swift
//  iOSbaseball
//
//  Created by KimMinSeok on 5/18/24.
//

import UIKit

class MainViewController: UIViewController, MainView {

    @IBOutlet weak var lifeLabel: UILabel!
    @IBOutlet weak var inputBall: UITextField!
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var collectionView: UICollectionView!
    
    var lifeCount : Int!
    var presenter : MainPresenter!
    
    
    let list: [GameResult] = GameResult.list
    
    enum Section {
        case main
    }
    typealias Item = GameResult
    
    var datasource: UICollectionViewDiffableDataSource<Section, Item>!
     
    override func viewDidLoad() {
        super.viewDidLoad()
        initBtn()
        configureCell()
        do {
            self.presenter = try MainPresenter(view: self, initLifeCount: lifeCount)
        } catch {
            print("에러 발생: \(error)")
        }
        
    }
    
    func showLife(lifeCount: Int) {
        lifeLabel.text = "남은 목숨 : \(lifeCount)"
    }
    
    func showInputError(inputText: String) {
        resultLabel.text = "올바르지 않은 형식의 입력입니다."
    }
    
    func showSuccess(opponentNumber: Int, lifeCount: Int) {
        lifeLabel.text = "남은 목숨 : \(lifeCount)"
        makeAlertDialog(title: "성공", message: "정답\(123)")
    }
    
    func showFail(opponentNumber: Int) {
        lifeLabel.text = "남은 목숨 : \(0)"
        makeAlertDialog(title: "실패", message: "정답\(123)")
    }
    
    func showResult(ball: Int, strike: Int){
        if ball == 0 && strike == 0 {
            resultLabel.text = "다틀림"
        }
        
        var output = ""
        if ball > 0 {
            output += "\(ball)볼 "
        }
        if strike > 0 {
            output += "\(strike )스트라이크"
        }
            
        resultLabel.text = output
    }
    
    
    @IBAction func challengeBtn(_ sender: Any) {
        presenter.game(userNumber: inputBall.text!)
        inputBall.text = ""
    }
    
    private func initBtn(){
        let backButton = UIBarButtonItem(title: "", style: .plain, target: self, action: #selector(backButtonTapped))
        backButton.image = UIImage(systemName: "chevron.left") // iOS 기본 chevron 이미지를 사용
        navigationItem.leftBarButtonItem = backButton
    }
    
    @objc func backButtonTapped() {
        dismiss(animated: true, completion: nil)
    }
    
    // Alert Dialog 생성
    func makeAlertDialog(title: String, message: String, _ isAlert : Bool = true) {

        let alert = isAlert ? UIAlertController(title: title, message: message, preferredStyle: .alert)
        
        : UIAlertController(title: title, message: message, preferredStyle: .actionSheet)
        
        let alertDeleteBtn = UIAlertAction(title: "재시작", style: .default) { (action) in
            print("재시작 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        let alertSuccessBtn = UIAlertAction(title: "나가기", style: .destructive) { (action) in
            print("나가기 버튼 클릭")
            self.dismiss(animated: true, completion: nil)
        }
        
        if(isAlert) {
            alert.addAction(alertDeleteBtn)
            alert.addAction(alertSuccessBtn)
        }
        else {
            alert.addAction(alertSuccessBtn)
            alert.addAction(alertDeleteBtn)
        }
        
        self.present(alert, animated: true, completion: nil)
    }
    
    func configureCell(){
        // Presentation, Data, Layout
        // Presentation
        datasource = UICollectionViewDiffableDataSource<Section, Item>(collectionView: collectionView, cellProvider: { collectionView, indexPath, itemIdentifier in
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "GameResultCollectionViewCell", for: indexPath) as? GameResultCollectionViewCell else {
                return nil
            }
            
//            let data = datalist[indexPath.item]
            cell.configure(itemIdentifier)
            return cell
        })
        
        // Data
        var snapshot = NSDiffableDataSourceSnapshot<Section, Item>()
        snapshot.appendSections([.main])
        snapshot.appendItems(list, toSection: .main)
        datasource.apply(snapshot)
        
        // Layout
        collectionView.collectionViewLayout = layout()
    }
    
    //Layout
    private func layout() -> UICollectionViewCompositionalLayout{
        let itemSize = NSCollectionLayoutSize(widthDimension: .fractionalWidth(0.33), heightDimension: .fractionalHeight(1))
        let item = NSCollectionLayoutItem(layoutSize: itemSize)
        
        let groupSize = NSCollectionLayoutSize(widthDimension: .fractionalWidth(1), heightDimension: .fractionalWidth(0.33))
        let group = NSCollectionLayoutGroup.horizontal(layoutSize: groupSize, subitem: item, count: 3)
        
        let section = NSCollectionLayoutSection(group: group)
        
        let layout = UICollectionViewCompositionalLayout(section: section)
        return layout
    }

}

