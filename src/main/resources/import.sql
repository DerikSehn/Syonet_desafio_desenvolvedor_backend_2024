-- Limpar as tabelas antes de inserir novos dados
-- DELETE FROM newsletters;
-- DELETE FROM customers;

-- Inserir registros na tabela "customers"
 INSERT INTO customers (id, name, email, birthdate) VALUES
 (1, 'John Doe', 'seu-email@exemplo.com', '1990-08-20');

-- Inserir registros na tabela "newsletters"
 INSERT INTO newsletters (id, title, description, link, sent) VALUES
 (1, 'News Today', 'Daily news and updates.', 'https://news.com/today', false),
 (2, 'Tech Innovations', 'Latest in technology and gadgets.', 'https://tech.com/innovations', false),
 (3, 'Health and Wellness', 'Tips for a healthy lifestyle.', 'https://health.com/wellness', false),
 (4, 'Travel Adventures', 'Explore new destinations and cultures.', 'https://travel.com/adventures', true),
 (5, 'Business Insights', 'In-depth analysis on business trends.', 'https://business.com/insights', true),
 (6, 'Food and Recipes', 'Delicious recipes and cooking tips.', 'https://food.com/recipes', false),
 (7, 'Fitness Goals', 'Achieve your fitness goals with these tips.', 'https://fitness.com/goals', false),
 (8, 'Education News', 'Updates on the education sector.', 'https://education.com/news', false),
 (9, 'Entertainment Weekly', 'Catch up on the latest entertainment news.', 'https://entertainment.com/weekly', true),
 (10, 'Finance and Investing', 'Strategies for financial success.', 'https://finance.com/investing', true);
