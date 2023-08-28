sql='select '

for i in range(0, 20000):
     var_name=f'a_{i}'
     # print(var_name)
     sql_format = f'''case
               when {var_name} in (999999999, 999999998) or {var_name} is null or
                    {var_name} = "" then 0
               when {var_name} <= 926.0 then 1
               when 926.0 < {var_name} and {var_name} <= 1252.0 then 2
               when 1252.0 < {var_name} and {var_name} <= 2051.0 then 3
               when 2051.0 < {var_name} and {var_name} <= 3281.0 then 4
               when 3281.0 < {var_name} and {var_name} <= 5346.0 then 5
               when 5346.0 < {var_name} and {var_name} <= 7379.0 then 6
               when 7379.0 < {var_name} and {var_name} <= 12712.0 then 7
               when 12712.0 < {var_name} and {var_name} <= 30850.0 then 8
               when {var_name} > 30850.0 then 9
               else 0 end as {var_name},'''
     sql +=sql_format
sql +='phone,dt from wms.table_a'

# print(sql)

with open('D:/tmp/a.sql', 'w') as f:
     f.write(sql)
