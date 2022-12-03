
   

def binary_sort_list(list):
    '''bsort the list'''
    start = 0 
    end = len(list)
    

''' assuming the list is sorted'''
def list_bs(list, num):
    found = False
    dict = {'Found': found, 'Number': num, "Index": False}
    '''O(log(n)) operation'''
    if len(list) == 1:
        if list[0] == num:
            found = True
            dict["Found"] = found
    elif len(list) == 2:
        if list[1] == num:
            found = True
            dict["Found"] = found
    else:
        ''' do search'''        
        start = 0
        end = len(list) - 1
        mid = round(end / 2)
        
        ''' loop '''
        # if less than mid
        while not found:
            if list[mid] == num:
                ''' check number'''
                found = True
                dict["Found"] = found
                dict["Index"] = mid
                print(f"Found the number '{num}' in the list at index '{mid}'!")
            elif num < list[mid]:
                ''' insert new indices '''
                end = mid
                mid = round(end / 2)
            elif num > list[mid]:
                start = mid
                new_len = (end - start) - 1
                mid = round(new_len / 2)
            elif mid == start or mid == end:
                print(f"Unable to find the number '{num}' in the list!")
                break
                
                
def test_binary_search():
    flag = True
    num_list = []
    while flag:
        res = input("Fill the list with numbers \nTo quit, enter 'q'\n"
                    + "Enter a number: ")  
        if res == 'q':
            break
        num_list.append(res)
        
    number = input("Enter a number you wish to search for: ")
    
    if len(num_list) != 0:
        list_bs(num_list, number)
    else:
        print("The list is empty!")


if __name__=="__main__":
    test_binary_search()
    